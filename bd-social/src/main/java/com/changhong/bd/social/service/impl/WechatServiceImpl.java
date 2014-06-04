package com.changhong.bd.social.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.social.domain.WechatAccessToken;
import com.changhong.bd.social.domain.WechatMenu;
import com.changhong.bd.social.entity.SocialBind;
import com.changhong.bd.social.parser.WechatMessageParser;
import com.changhong.bd.social.plugin.WechatProcessPlugin;
import com.changhong.bd.social.service.api.SocialService;
import com.changhong.bd.social.service.api.WechatService;
import com.changhong.bd.social.utils.SocialTypeUtils;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.utils.WechatUtils;
import com.changhong.bd.social.utils.WechatXmlUtils;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description :
 */
@Service("wechatService")
public class WechatServiceImpl implements WechatService {
	private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);
		
	//private static final String AK = "wx2b2e75b10999bc54";
	//private static final String SK = "5b5220e01c92d2a8c39d1e687988b75e";
	
	@Autowired
	private NetworkService networkService;
	
	@Autowired
	@Qualifier("socialService")
	private SocialService socialService;
	
	@Autowired
	private WechatMessageParser wechatMessageParser;

	//TODO 历史上下文消息
	/**
	 * 处理点击的插件
	 */
	private List<WechatProcessPlugin> clickPlugins = new ArrayList<WechatProcessPlugin>();
//	/**
//	 * 事件插件 暂时不启用
//	 */
//	private List<WechatProcessPlugin> eventPlugins = new ArrayList<WechatProcessPlugin>();
	/**
	 * 任何消息插件 - 次低优先级，略高于帮助插件
	 */
	private List<WechatProcessPlugin> allPlugins = new ArrayList<WechatProcessPlugin>();
	/**
	 * 文本插件
	 */
	private List<WechatProcessPlugin> textPlugins = new ArrayList<WechatProcessPlugin>();
	/**
	 * 帮助插件 - 当前面所有的信息都没有匹配成功的情况下，就调用帮助插件进行消息回复
	 */
	private WechatProcessPlugin helpPlugin = null;
	
	@Autowired
	public void setPlugin(List<WechatProcessPlugin> plugins){
		if(null!=plugins){
			logger.info("wechat plugin register size："+plugins.size());
			for(WechatProcessPlugin p : plugins){
				logger.info("wechat plugin detail:"+p.getClass().getName());
				String type = p.messageType();
				if(WechatMessageUtils.EVENT_TYPE_CLICK.equals(type)){
					this.clickPlugins.add(p);
				}else if(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT.equals(type)){
					this.textPlugins.add(p);
				}else if("*".equals(type)){
					this.allPlugins.add(p);
				}else if("help".equals(type)){
					this.helpPlugin = p;
				}
			}
			Collections.sort(clickPlugins);
			Collections.sort(textPlugins);
			Collections.sort(allPlugins);
		}
	}
	@Override
	public String process(InputStream is) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = WechatXmlUtils.parseXml(is);

			BaseInMessage msg = this.wechatMessageParser.parse(requestMap);
			String msgType = msg.getMsgType();
			
			
			//默认回复  回复文本消息 demo
			TextOutMessage textMessage = new TextOutMessage(msg);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			//解析绑定信息
			List<SocialBind> e = this.socialService.queryByOpenId(SocialTypeUtils.WECHAT, msg.getFromUserName());
			String accountId = "";
			if(null!=e && e.size()>0){
				accountId = e.get(0).getAccountId();
			}
			// 文本消息
			if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT)) {
				String rep = "";
				TextInMessage tim = (TextInMessage)msg;
				for(WechatProcessPlugin plugin : textPlugins){
					
					if(plugin.want(tim.getContent())){
						rep = plugin.process(tim, null, accountId);
						
						if(StringUtils.isNotEmpty(rep)){
							return rep;
						}
					};
				}
			}
			// 图片消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "图片信息";
			}
			// 地理位置消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "Location message";
			}
			// 链接消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "Link message";
			}
			// 音频消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "Voice message";
			}
			// 事件推送
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(WechatMessageUtils.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "Thanks for your favourate!";
				}
				// 取消订阅
				else if (eventType.equals(WechatMessageUtils.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(WechatMessageUtils.EVENT_TYPE_CLICK)) {
					
					String eventKey = requestMap.get("EventKey");
					if(this.clickPlugins.size()>0){
						for(WechatProcessPlugin p : this.clickPlugins){
							if(p.want(eventKey)){
								String res = p.process(msg, null, accountId);
								if(StringUtils.isNotEmpty(res)){
									return res;
								}
							}
						}
					}
				}
			}


			if(helpPlugin!=null){
				return helpPlugin.process(msg, null, accountId);
			}
			//返回默认信息
			textMessage.setContent(respContent);
			respMessage = WechatXmlUtils.textMessageToXml(textMessage);
			return respMessage;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public WechatAccessToken queryToken(String ak, String sk) {
		WechatAccessToken accessToken = null;

		String requestUrl = WechatUtils.getAccessTokenUrl().replace("APPID", ak).replace("APPSECRET", sk);
		JSONObject jsonObject = networkService.httpsRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new WechatAccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	@Override
	public int createMenu(WechatMenu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = WechatUtils.getMenuCreateUrl().replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = networkService.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}
	
	@Override
	public String[] queryAkSk() {
		return new String[]{
			WechatUtils.getWechatAk(),WechatUtils.getWechatSk()
		};
	}

}

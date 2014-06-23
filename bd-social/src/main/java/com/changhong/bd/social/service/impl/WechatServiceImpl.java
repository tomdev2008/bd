package com.changhong.bd.social.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.entity.WechatChannelEntity;
import com.changhong.bd.social.service.api.WechatChannelService;
import com.changhong.bd.social.service.api.WechatService;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.BaseEventMessage;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.parser.InMessageObjectParser;
import com.changhong.bd.social.wechat.parser.OutMessageXmlParser;
import com.changhong.bd.social.wechat.processer.ButtonEventProcesser;
import com.changhong.bd.social.wechat.processer.MessageProcesser;
import com.changhong.bd.social.wechat.processer.SubscribeEventProcesser;
import com.changhong.bd.social.wechat.processer.UnsubscribeEventProcesser;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description :
 */
@Service("wechatService")
public class WechatServiceImpl implements WechatService {
	
	private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);
	
	@Autowired
	private InMessageObjectParser inMessageObjectParser;
	@Autowired
	private OutMessageXmlParser outMessageXmlParser;
	@Autowired
	private WechatChannelService wechatChannelService;
	//=========微信信息处理器 start =================
	@Autowired
	private ButtonEventProcesser buttonEventProcesser;
	@Autowired
	private MessageProcesser messageProcesser;
	@Autowired
	private SubscribeEventProcesser subscribeEventProcesser;
	@Autowired
	private UnsubscribeEventProcesser unsubscribeEventProcesser;
	//========微信信息处理器 end =======================
	
	@Override
	public String process(InputStream is) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理失败！";

			// xml请求解析
			Map<String, String> requestMap = outMessageXmlParser.parseXml(is);

			BaseInMessage msg = this.inMessageObjectParser.parse(requestMap);
			String msgType = msg.getMsgType();
			
			//用户当前所属的频道
			WechatChannelDto channel = this.wechatChannelService.queryCurrent(msg.getFromUserName());

			WechatProcessResult result = null;
			// 文本消息
			if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT)) {
				TextInMessage tim = this.inMessageObjectParser.parseTextMessage(msg, requestMap);
				result = this.messageProcesser.process(tim, channel);
			}
			// 图片消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "图片信息";
				//TODO
			}
			// 地理位置消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "Location message";
				//TODO
			}
			// 链接消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "Link message";
				//TODO
			}
			// 音频消息
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "Voice message";
				//TODO
			}
			// 事件推送
			else if (msgType.equals(WechatMessageUtils.REQ_MESSAGE_TYPE_EVENT)) {
				BaseEventMessage em = this.inMessageObjectParser.parseEventMessage(msg, requestMap);
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(WechatMessageUtils.EVENT_TYPE_SUBSCRIBE)) {
					result = this.subscribeEventProcesser.process(em, channel);
				}
				// 取消订阅
				else if (eventType.equals(WechatMessageUtils.EVENT_TYPE_UNSUBSCRIBE)) {
					result = this.unsubscribeEventProcesser.process(em, channel);
				}
				// 自定义菜单点击事件
				else if (eventType.equals(WechatMessageUtils.EVENT_TYPE_CLICK)) {
					ClickEventMessage cem = this.inMessageObjectParser.parseClickEventMessage(em, requestMap);
					result = this.buttonEventProcesser.process(cem, channel);
				}
				else if(eventType.equals(WechatMessageUtils.EVENT_TYPE_VIEW)){
					ClickEventMessage cem = this.inMessageObjectParser.parseClickEventMessage(em, requestMap);
					//TODO
				}
			}
			
			if(null!=result){
				if(null!=result.getChannel()){
					WechatChannelEntity entity = new WechatChannelEntity(result.getChannel());
					//执行channel更新
					this.wechatChannelService.add(entity );
				}
				respMessage = outMessageXmlParser.outMessageToXml(result.getMsg());
				
				logger.debug(respMessage);
				
				return respMessage;
			}else{

				//默认回复  回复文本消息 demo
				TextOutMessage textMessage = new TextOutMessage(msg);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				
				//返回默认信息
				textMessage.setContent(respContent);
				respMessage = outMessageXmlParser.textMessageToXml(textMessage);
				
				return respMessage;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	
}

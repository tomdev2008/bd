package com.changhong.bd.spider.wechat;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.social.entity.SocialWechatMessage;
import com.changhong.bd.social.plugin.AbsWechatProcessPlugin;
import com.changhong.bd.social.service.api.SocialService;
import com.changhong.bd.social.utils.SocialTypeUtils;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.utils.WechatXmlUtils;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月14日
 * @version 1.0 TODO 测试版
 * @description : 微信插件： 登陆模块
 */
@Service("wechatHelpClickPlugin")
public class WechatHelpClickPlugin extends AbsWechatProcessPlugin{

	@Autowired
	private SocialService socialService;
	
	@Autowired
	private SysAccountService sysAccountService;
	
	@Override
	public boolean want(String info) {
		//处理 帮助按钮的信息
		return "wx_help".equals(info);
	}

	@Override
	public String messageType() {
		return WechatMessageUtils.EVENT_TYPE_CLICK;
	}

	/**************
	 * 
	 * 业务逻辑： 
	 * 	1.判断微信用户是否已经绑定了内部账户。
	 * 	2.如果已经绑定，信息（1）欢迎：**，（2）操作提示
	 * 	3.没有登陆，就是：请登陆，发送登陆URL地址
	 * 
	 **************/
	@Override
	public String process(BaseInMessage msg, List<SocialWechatMessage> history, String accountId) {
		
		TextOutMessage textMessage = new TextOutMessage(msg);
		if(StringUtils.isNotEmpty(accountId)){
			SysAccountDto dto = this.sysAccountService.queryById(accountId);
			//提示，欢迎某某，这里是帮助信息
			String content = dto.getName() + ",欢迎您,这里是帮助信息。";
			textMessage.setContent(content);
		}else{
			//提示，登陆
			String content = "<a href=\"http://bdspider.duapp.com/social/sign/in?socialType="+SocialTypeUtils.WECHAT+"&socialId="+msg.getFromUserName()+"\">点击这里登陆</a>";
			textMessage.setContent(content);
		}
		return WechatXmlUtils.textMessageToXml(textMessage);

	}

	@Override
	public Integer getPriority() {
		//较低优先级
		return new Integer(5);
	}

}

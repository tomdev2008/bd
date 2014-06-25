package com.changhong.bd.spider.wechat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.entity.SocialBindEntity;
import com.changhong.bd.social.service.api.SocialService;
import com.changhong.bd.social.utils.SocialTypeUtils;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessButtonEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月14日
 * @version 1.0 
 * @description : 微信插件： 账号绑定
 */
@Service("wechatHelpClickPlugin")
public class WechatBindPlugin extends AbsProcessButtonEventPlugin{

	@Autowired
	private SocialService socialService;
	
	@Autowired
	private SysAccountService sysAccountService;

	@Override
	public Integer getPriority() {
		return new Integer(100);
	}

	@Override
	public String getEventKey() {
		return "bind_account";
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
	public WechatProcessResult process(ClickEventMessage msg, WechatChannelDto channel) {
		TextOutMessage textMessage = new TextOutMessage(msg);
		List<SocialBindEntity> list = socialService.queryByOpenId(SocialTypeUtils.WECHAT, msg.getFromUserName());
		if(null!=list && list.size()>0){
			//已经绑定了账户
			SysAccountDto dto = this.sysAccountService.queryById(list.get(0).getAccountId());
			//提示，欢迎某某，这里是帮助信息
			String content = dto.getName() + ",欢迎您,这里是帮助信息。";
			textMessage.setContent(content);
		}else{
			//尚未绑定账户
			String content = "<a href=\"http://bdspider.duapp.com/social/sign/in?socialType="+SocialTypeUtils.WECHAT+"&socialId="+msg.getFromUserName()+"\">点击这里登陆</a>";
			textMessage.setContent(content);
		}

		WechatProcessResult res = new WechatProcessResult(textMessage, null);
		return res;
	}

}

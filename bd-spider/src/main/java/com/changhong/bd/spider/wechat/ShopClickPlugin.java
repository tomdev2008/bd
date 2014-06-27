package com.changhong.bd.spider.wechat;

import java.util.List;

import org.springframework.stereotype.Component;

import com.changhong.bd.core.domain.SysAccountDto;
import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.entity.SocialBindEntity;
import com.changhong.bd.social.utils.SocialTypeUtils;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessMessagePlugin;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月27日
 * @version 1.0
 * @description :
 */
@Component
public class ShopClickPlugin extends AbsProcessMessagePlugin {

	@Override
	public String getChannelId() {
		return "";
	}

	@Override
	public Integer getPriority() {
		return 200;
	}

	@Override
	public WechatProcessResult process(TextInMessage msg, WechatChannelDto channel) {
		TextOutMessage textMessage = new TextOutMessage(msg);

		String content = "了解CHiQ产品，请进<a href=\"http://bdspider.duapp.com/social/sign/in?socialType=CHiQ商城"+"\">点击这里登陆</a>。了解长虹产品，请进长虹在线。" + SocialTypeUtils.WECHAT + "&socialId="
				+ msg.getFromUserName() + "\">点击这里登陆</a>";
		textMessage.setContent(content);

		WechatProcessResult res = new WechatProcessResult(textMessage, null);
		return res;
	}

}

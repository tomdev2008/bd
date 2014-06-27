package com.changhong.bd.spider.wechat;

import org.springframework.stereotype.Component;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.social.wechat.plugin.AbsProcessMessagePlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月27日
 * @version 1.0
 * @description : 微信服务插件 TODO
 */
@Component
public class WechatServiceMessagePlugin extends AbsProcessMessagePlugin{

	@Override
	public String getChannelId() {
		return "wechat_service";
	}

	@Override
	public Integer getPriority() {
		return 200;
	}

	@Override
	public WechatProcessResult process(TextInMessage msg, WechatChannelDto channel) {
		WechatProcessResult res = new WechatProcessResult(null, null);
		return res;
	}
}

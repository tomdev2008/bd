package com.changhong.bd.social.wechat.processer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.BaseEventMessage;
import com.changhong.bd.social.wechat.plugin.ProcessSubscribeEventPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 关注事件处理器
 */
@Service
public class SubscribeEventProcesser {
	/**
	 * 关注事件插件，该插件最多只能有1个
	 */
	@Autowired(required=false)
	private ProcessSubscribeEventPlugin wechatProcessSubscribeEventPlugin;

	public WechatProcessResult process(BaseEventMessage em, WechatChannelDto channel) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

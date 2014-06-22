package com.changhong.bd.social.wechat.plugin;

import com.changhong.bd.social.wechat.message.in.BaseEventMessage;
import com.changhong.bd.social.wechat.message.out.BaseOutMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 微信处理关注事件的插件接口。
 * 	注意：
 * 		该插件，有且只能有一个。
 */
public interface ProcessSubscribeEventPlugin {

	/**
	 * 关注事件，处理器
	 * @param bem
	 * @return
	 */
	public BaseOutMessage process(BaseEventMessage bem);
}

package com.changhong.bd.social.wechat.plugin;

import com.changhong.bd.social.wechat.message.in.BaseEventMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 
 * 	取消订阅处理接口.处理数量不限制
 */
public interface ProcessUnsubscribeEventPlugin 
	extends Comparable<ProcessUnsubscribeEventPlugin>{

	public void process(BaseEventMessage bem);
}

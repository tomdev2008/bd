package com.changhong.bd.social.wechat.plugin;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月21日
 * @version 1.0
 * @description : 微信，按钮事件处理器 接口
 */
public interface ProcessButtonEventPlugin 
	extends Comparable<ProcessButtonEventPlugin>{

	/**
	 * 获取点击事件的KEY值。
	 * 	点击事件分为，点击普通按钮事件/点击URL按钮事件
	 * @return
	 */
	public String getEventKey();
	
	/**
	 * 获取优先级   数字越大，优先级越高
	 * @return
	 */
	public Integer getPriority();
	/**
	 * 处理该消息
	 * @return
	 */
	public WechatProcessResult process(BaseInMessage msg, WechatChannelDto channel);

}

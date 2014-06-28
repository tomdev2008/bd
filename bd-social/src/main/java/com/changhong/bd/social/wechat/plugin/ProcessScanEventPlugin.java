package com.changhong.bd.social.wechat.plugin;

import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.ScanEventInMessage;

public interface ProcessScanEventPlugin 
	extends Comparable<ProcessScanEventPlugin>{

	/**
	 * 获取点击事件的KEY值。
	 * 	点击事件分为，点击普通按钮事件/点击URL按钮事件
	 * @return
	 */
	public boolean want(String qrscene);
	/**
	 * 获取优先级   数字越大，优先级越高
	 * @return
	 */
	public Integer getPriority();
	/**
	 * 处理该消息
	 * @return
	 */
	public WechatProcessResult process(ScanEventInMessage msg);

}

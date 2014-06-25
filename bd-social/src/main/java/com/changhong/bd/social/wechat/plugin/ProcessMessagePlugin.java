package com.changhong.bd.social.wechat.plugin;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.TextInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public interface ProcessMessagePlugin 
	extends Comparable<ProcessMessagePlugin>{

	/**
	 * 插件所属的channel,
	 * 	""，表示任何channelName都处理，此类插件优先级已经改最低。
	 * @return
	 */
	public String getChannelId();

	
	/**
	 * 获取优先级   数字越大，优先级越高
	 * @return
	 */
	public Integer getPriority();
	/**
	 * 处理该消息
	 * @return
	 */
	public WechatProcessResult process(TextInMessage msg, WechatChannelDto channel);

	
}

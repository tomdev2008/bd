package com.changhong.bd.social.plugin;

import java.util.List;

import com.changhong.bd.social.entity.SocialWechatMessage;
import com.changhong.bd.social.wechat.message.in.BaseInMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.1
 * @description : 
 * 	 微信插件接口 TODO
 * 	 新增了排序接口,并提供了
 */
public interface WechatProcessPlugin extends Comparable<WechatProcessPlugin>{

	/**
	 * 消息内容匹配，用户回复的消息匹配的时候才调用这个接口<br/>
	 *  	<p>info:
	 * 		<p>信息文本的内容， content字段
	 * 		<p>点击菜单的标识符， 菜单的 key字段
	 * 		<p>事件的信息, Event字段
	 * @return 是否有意愿处理这个信息
	 */
	public boolean want(String info);
	/**
	 * 消息类型匹配，默认*，匹配全部   : WechatMessageUtils 静态变量 help 帮助类型插件,只能有一个
	 * @return 处理消息的类型
	 */
	public String messageType();
	
	/**
	 * 获取优先级   数字越大，优先级越高
	 * @return
	 */
	public Integer getPriority();
	/**
	 * 回复信息
	 * @param msg 本次的消息
	 * @param history 信息上下文
	 * @param accountId 系统账户的ID，可能是""，表示登陆绑定
	 * @return
	 */
	public String process(BaseInMessage msg, List<SocialWechatMessage> history, String accountId);
	
}

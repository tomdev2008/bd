package com.changhong.bd.social.wechat.plugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月25日
 * @version 1.0
 * @description : 
 */
public abstract class AbsProcessMessagePlugin 
	implements ProcessMessagePlugin{

	@Override
	public int compareTo(ProcessMessagePlugin o) {
		return this.getPriority() - o.getPriority();
	}


}

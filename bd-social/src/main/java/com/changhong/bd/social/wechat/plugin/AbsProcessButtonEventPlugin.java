package com.changhong.bd.social.wechat.plugin;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月23日
 * @version 1.0
 * @description : 
 */
public abstract class AbsProcessButtonEventPlugin implements ProcessButtonEventPlugin {

	@Override
	public int compareTo(ProcessButtonEventPlugin o) {
		return this.getPriority() - o.getPriority();
	}

}

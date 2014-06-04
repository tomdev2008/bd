package com.changhong.bd.core.priority;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 优先级接口
 */
public interface Priority {

	/**
	 * 获取优先级值,值越大，越高
	 * @return
	 */
	public Integer getPriority();
}

package com.changhong.bd.log.service.api;

import java.io.Serializable;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 持久化审计日志
 */
public interface LogService {

	/**
	 * 可以序列化的对象进行保存
	 * @param serial 序列化对象
	 * @param modifyId 修改信息主ID
	 */
	public void addLog(Serializable serial, String modifyId);
	
}

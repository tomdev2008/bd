package com.changhong.bd.core.utils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月19日
 * @version 1.0
 * @description : 
 */
public class BeanUtils {

	/**
	 * 复制属性
	 * @param dist
	 * @param src
	 */
	public static void copyProperties(Object dist, Object src){
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dist, src);
		} catch (IllegalAccessException | InvocationTargetException e) {
			RuntimeException re = new RuntimeException(e);
			throw re;
		}
	}
}

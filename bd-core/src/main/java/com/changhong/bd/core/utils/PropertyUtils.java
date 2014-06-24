package com.changhong.bd.core.utils;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 属性工具类
 */
public class PropertyUtils {
	public static final String APP_ID_KEY = "appid";

	/**
	 * 获取系统的APP ID
	 * @return
	 */
	public static String getAppId(){
		return System.getProperty(APP_ID_KEY);
	}
}

package com.changhong.bd.social.utils;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 微信工具类 用于获取URL， AK SK等信息
 */
public class WechatUtils {

	public static final String SOCIAL_WECHAT_ACCESS_TOKEN_URL_KEY = "Social.WechatAccessTokenUrl";
	public static final String SOCIAL_WECHAT_MENU_CREATE_URL_KEY = "Social.WechatMenuCreateUrl";
	public static final String APP_ID_KEY = "appid";
	/**
	 * 获取微信AccessTokenUrl
	 * @return
	 */
	public static String getAccessTokenUrl(){
		return System.getProperty(SOCIAL_WECHAT_ACCESS_TOKEN_URL_KEY);
	}
	/**
	 * 获取微信的创建菜单URL
	 * @return
	 */
	public static String getMenuCreateUrl(){
		return System.getProperty(SOCIAL_WECHAT_MENU_CREATE_URL_KEY);
	}
	/**
	 * 获取系统的APP ID
	 * @return
	 */
	public static String getAppId(){
		return System.getProperty(APP_ID_KEY);
	}
}

package com.changhong.bd.network.service.api;

import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 网络Json服务
 */
public interface NetworkService {
	public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr);

	public String httpsPost(String url, Map<String, String> values, String postData);

	/**
	 * HTTP GET 请求， 返回String字符串
	 * @param url
	 * @param values
	 * @param isSecurity 是否使用https
	 * @return
	 */
	public String httpGet(String url, Map<String,String> values, Boolean isSecurity);
	/**
	 * 
	 * @param url
	 * @param values
	 * @return
	 */
	public String httpGet(String url, Map<String, String> values);
}
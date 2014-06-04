package com.changhong.bd.network.service.api;

import net.sf.json.JSONObject;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 网络Json服务
 */
public interface NetworkService {
	public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr);
}
package com.changhong.bd.social.service.api;

import com.changhong.bd.social.domain.WechatAccessToken;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 微信token服务
 */
public interface WechatTokenService {

	/**
	 * 获取token
	 * @return
	 */
	public WechatAccessToken queryToken();
	
	/**
	 * 强制刷新token
	 */
	public void freshToken();
}

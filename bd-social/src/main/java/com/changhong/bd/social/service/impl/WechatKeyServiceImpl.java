package com.changhong.bd.social.service.impl;

import org.springframework.stereotype.Service;

import com.changhong.bd.core.utils.PropertyUtils;
import com.changhong.bd.social.service.api.WechatKeyService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
@Service("wechatKeyService")
public class WechatKeyServiceImpl 
	implements WechatKeyService{

	public static final String WECHAT_AK_KEY = "wechatak";
	public static final String WECHAT_SK_KEY = "wechatsk";
	
	@Override
	public String queryAk() {
		String key = PropertyUtils.getAppId() + "." + WECHAT_AK_KEY;
		return System.getProperty(key);
	}

	@Override
	public String querySk() {
		String key = PropertyUtils.getAppId() + "." + WECHAT_SK_KEY;
		return System.getProperty(key);
	}
}

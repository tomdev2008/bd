package com.changhong.bd.bae.service.impl;

import org.springframework.stereotype.Service;

import com.changhong.bd.bae.service.api.BaeService;
import com.changhong.bd.core.utils.PropertyUtils;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 
 */
@Service("baeService")
public class BaeServiceImpl
	implements BaeService{


	public static final String BAE_AK = "baeak";
	public static final String BAE_SK = "baesk";
	
	@Override
	public String queryAk() {
		String key = PropertyUtils.getAppId() + "." + BAE_AK;
		return System.getProperty(key);
	}

	@Override
	public String querySk() {
		String key = PropertyUtils.getAppId() + "." + BAE_SK;
		return System.getProperty(key);
	}


}

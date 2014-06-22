package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.service.api.WechatTokenService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public class TestForWechatTokenService 
	extends AbstractTestRunner{

	@Autowired
	private WechatTokenService wechatTokenService;
	
	@Test
	public void testQueryToken(){
		out(this.wechatTokenService.queryToken());
		out(this.wechatTokenService.queryToken());
	}
}

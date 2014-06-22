package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.service.api.WechatKeyService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public class TestForWechatKeyService 
	extends AbstractTestRunner{

	@Autowired
	private WechatKeyService wechatKeyService;
	
	@Test
	public void testQueryAkSk(){
		out(this.wechatKeyService.queryAk());
		out(this.wechatKeyService.querySk());
	}
}

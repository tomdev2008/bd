package com.changhong.bd.bae.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.bae.service.api.BaeService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 
 */
public class TestForBaeService 
	extends AbstractTestRunner{

	@Autowired
	private BaeService baeService;
	
	@Test
	public void testForQueryKey(){
		out(this.baeService.queryAk());
		out(this.baeService.querySk());
	}
	
}

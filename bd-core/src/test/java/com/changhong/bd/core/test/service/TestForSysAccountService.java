package com.changhong.bd.core.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月26日
 * @version 1.0
 * @description :
 */
public class TestForSysAccountService extends AbstractTestRunner{

	@Autowired
	private SysAccountService sysAccountService;

	@Test
	public void testQueryById() {
		this.sysAccountService.queryById("8a83b6b14641fc5c014641fcc4a20000");
	}
}

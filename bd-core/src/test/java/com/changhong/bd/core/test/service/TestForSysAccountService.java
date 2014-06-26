package com.changhong.bd.core.test.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.core.service.api.SysAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月26日
 * @version 1.0
 * @description :
 */
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class TestForSysAccountService extends AbstractJUnit4SpringContextTests {

	private static Logger logger = LoggerFactory.getLogger(TestForSysUserService.class);
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private SysAccountService sysAccountService;

	@Test
	public void testQueryById() {
		this.sysAccountService.queryById("8a83b6b14641fc5c014641fcc4a20000");
	}
}

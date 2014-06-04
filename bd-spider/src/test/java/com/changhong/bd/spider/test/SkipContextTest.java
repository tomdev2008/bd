package com.changhong.bd.spider.test;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 这里的测试，受到外部环境限制，不能每次编译，每次测试
 */
@ContextConfiguration(locations={
		"classpath*:/applicationContext.xml",
		"classpath*:/applicationContext-mail.xml",
		"classpath*:/applicationContext-spider.xml"
})
public class SkipContextTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void test(){
		System.out.println(this.getClass().getName());
	}

	
}
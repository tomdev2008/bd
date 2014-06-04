package com.changhong.bd.core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.changhong.bd.core.service.impl.LocalSysPropertiesServiceImpl;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月4日
 * @version 1.0
 * @description : 本地属性配置装载服务
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml"
})
public class TestForLocalSysPropertiesServiceImpl
	extends AbstractJUnit4SpringContextTests{

	@Autowired
	private LocalSysPropertiesServiceImpl localSysPropertiesServiceImpl;
	
	/**
	 * 测试，从系统获取属性配置
	 */
	@Test
	public void testForGetProperty(){
		String tony = System.getProperty("auther");
		Assert.isTrue("tony".equals(tony));
	}
	
}

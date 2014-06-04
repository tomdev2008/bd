package com.changhong.bd.core.test.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月27日
 * @version 1.0
 * @description : 用户控制器 单元测试
 */
@ContextConfiguration(locations={
	"classpath:/applicationContext.xml",
	"classpath:/spring-mvc.xml"
})
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = true)
public class TestForSysUserController extends AbstractJUnit4SpringContextTests{

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mvc;
	
	@Before
	public void beforeTest(){
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/**
	 * 测试分页获取
	 * @throws Exception
	 */
	@Test
	public void testGetQuery() throws Exception{
		ResultActions ra = mvc.perform(
				MockMvcRequestBuilders
				.get("/sys/user")
				.param("pageNo", "1")
				.param("pageSize", "10")
				.param("name", "漆尧"));
		
		ra.andExpect(MockMvcResultMatchers.status().isOk());
		MvcResult mr = ra.andReturn();
		String s = mr.getResponse().getContentAsString();
		logger.info(s);
	}
	
	public void testQueryById() throws Exception{
		ResultActions ra = mvc.perform(
				MockMvcRequestBuilders
				.put("/sys/user/01")
				.param("name", ""));
		//TODO
		logger.info(ra);
	}
}

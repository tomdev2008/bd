package com.changhong.bd.core.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 单元测试超类
 */
@ContextConfiguration(locations={
		"classpath*:/applicationContext.xml"
 })
public class AbstractTestRunner extends AbstractJUnit4SpringContextTests {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected ObjectMapper om = new ObjectMapper();
	
	/**
	 * 输出ajax对象
	 * @param ra
	 * @throws Exception
	 */
	public void ajaxOut(ResultActions ra ) throws Exception{
		ra.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
  	
		MvcResult mr = ra.andReturn();
		String result = mr.getResponse().getContentAsString();
		out(result);
	}
	/**
	 * 文本输出
	 * @param o
	 */
	public void out(Object o){
		
		try {
			String s = om.writeValueAsString(o);
			logger.info(s);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

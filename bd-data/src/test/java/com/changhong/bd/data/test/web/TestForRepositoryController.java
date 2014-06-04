package com.changhong.bd.data.test.web;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.changhong.bd.core.runner.AbstractWebTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 
 */
@WebAppConfiguration
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml",
	"classpath*:/spring-mvc.xml"
})
public class TestForRepositoryController extends AbstractWebTestRunner{
	/**
	 * 查询仓库的详细信息
	 * @throws Exception
	 */
	@Test
	public void testQueryDetail() throws Exception{
		ResultActions ra = this.mockMvc.perform(
				MockMvcRequestBuilders.get("/data/repository/01")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
		
		ajaxOut(ra);
		
		ra = this.mockMvc.perform(
				MockMvcRequestBuilders.get("/data/repository/hlxd")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
		
	}
	/**
	 * 测试查询所有的仓库信息
	 * @throws Exception
	 */
	@Test
	public void testQuery() throws Exception{
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/data/repository").accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
		
		ajaxOut(ra);
	}
	
	
}

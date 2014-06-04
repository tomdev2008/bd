package com.changhong.bd.data.test.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月30日
 * @version 1.0
 * @description : 单元测试： 数据定义仓库服务
 */
@ContextConfiguration(locations={
		"classpath*:/applicationContext.xml"
	})
public class TestForDataDefinitionStoreService 
	extends AbstractJUnit4SpringContextTests{

	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	
	private static ObjectMapper om = new ObjectMapper();
	private static Logger logger = LoggerFactory.getLogger(TestForDataDefinitionStoreService.class);
	
	/**
	 * 测试：查询所有的仓库定义
	 * @throws JsonProcessingException 
	 */
	@Test
	public void testQueryDefinition() throws JsonProcessingException{
		JsonData<RepositoryDto> jd = this.dataDefinitionStoreService.queryAllRepository("tonyq");
		jd = this.dataDefinitionStoreService.queryAllRepository("");
		out(jd.getDatas());
	}
	
	@Test
	public void testQueryById(){
		RepositoryEntity e = this.dataDefinitionStoreService.query("01");
		out(e);
		e = this.dataDefinitionStoreService.query("lqbz");
		out(e);
	}
	
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

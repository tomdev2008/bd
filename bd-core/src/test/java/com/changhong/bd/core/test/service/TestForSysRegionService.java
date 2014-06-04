package com.changhong.bd.core.test.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.core.domain.SysRegionDto;
import com.changhong.bd.core.entity.SysRegionEntity;
import com.changhong.bd.core.service.api.SysRegionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 地区服务 单元测试
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml"
})
public class TestForSysRegionService extends AbstractJUnit4SpringContextTests {

	private static Logger logger = LoggerFactory.getLogger(TestForSysRegionService.class);
	private ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private SysRegionService sysRegionService;
	
	/**
	 * 测试查询地区树
	 * @throws JsonProcessingException 
	 */
	@Test
	public void testQueryRegionTree() throws JsonProcessingException{
		SysRegionDto dto = this.sysRegionService.querySysRegionTree();
		String s = om.writeValueAsString(dto);
		logger.info(s);
	}
	/**
	 * 测试添加地区
	 */
	@Test
	public void testAddRemoveRegion(){
		SysRegionEntity entity = new SysRegionEntity();
		SysRegionEntity parent = new SysRegionEntity();
		
		parent.setId("0");
		
		entity.setParent(parent);
		entity.setName("测试地区");
		entity.setPostcode("621000");
		entity.setRegionLevel("state");
		entity.setStatus(1);
		
		entity = this.sysRegionService.addSysRegion(entity );
		this.sysRegionService.deleteSysRegion(entity.getId());
	}
}

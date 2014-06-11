package com.changhong.bd.data.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.data.domain.DataReporterDto;
import com.changhong.bd.data.entity.DataReporterEntity;
import com.changhong.bd.data.service.api.DataReporterService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 
 */
public class TestForDataReporterService 
	extends AbstractTestRunner{

	@Autowired
	private DataReporterService dataReporterService;
	
	private DataReporterDto dto;
	@Test
	public void testForQueryAll(){
		out(this.dataReporterService.query());
	}
	@Test
	public void testForQueryById(){
		out(this.dataReporterService.query(dto.getId()));
	}
	@Before
	public void testForAdd(){
		DataReporterEntity e = new DataReporterEntity();
		e.setName("测试报表");
		e.setUserId("01");
		e.setUserName("Tony");
		dto = this.dataReporterService.add(e);
	}
	@After
	public void testForDelete(){
		if(null!=dto){
			this.dataReporterService.delete(dto.getId());
		}
	}
}

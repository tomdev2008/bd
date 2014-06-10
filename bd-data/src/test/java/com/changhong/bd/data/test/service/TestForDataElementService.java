package com.changhong.bd.data.test.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.runner.AbstractTestRunner;
import com.changhong.bd.data.domain.DataElementGroupDto;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.entity.DataElementGroupEntity;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DataElementService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月10日
 * @version 1.0
 * @description : 数据元素单元测试
 */
public class TestForDataElementService extends AbstractTestRunner {

	@Autowired
	private DataElementService dataElementService;
	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	
	private DataElementGroupEntity group = null;
	@Test
	public void testForQueryEleGroup(){
		JsonData<RepositoryDto> jd = this.dataDefinitionStoreService.queryAllRepository(null);
		List<DataElementGroupDto> list = this.dataElementService.query(jd.getDatas().get(0).getId());
		this.out(list);
	}
	
	@Test
	public void testAddEleGroup() throws SQLException{
		group = this.dataElementService.addSqlDataElement("CHiQ三看", "select time,category,contain_store_tv,modes,content,create_time,update_time from chiq_watch_time_analy", "01");
	}
	@After
	public void testDeleteGroup(){
		if(null!=group){
			this.dataElementService.deleteSqlDataElement(group.getId());
		}
	}
}

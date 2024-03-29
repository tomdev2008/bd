package com.changhong.bd.data.test.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.data.domain.DataElementGroupDto;
import com.changhong.bd.data.domain.RepositoryDto;
import com.changhong.bd.data.entity.DataElementGroupEntity;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DataElementService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

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
	
	/**
	 * 测试查询所有的查询服务
	 */
	@Test
	public void testForQueryAll(){
		List<DataElementGroupDto> liste = this.dataElementService.query();
		this.out(liste);
	}
	/**
	 * 测试：通过rep查询数据元素集合
	 */
	@Test
	public void testForQueryEleGroup(){
		JsonData<RepositoryDto> jd = this.dataDefinitionStoreService.queryAllRepository(null);
		List<DataElementGroupDto> list = this.dataElementService.query(jd.getDatas().get(0).getId());
		this.out(list);
	}
	/**
	 * 测试添加数据元素
	 * @throws SQLException
	 */
	@Test
	public void testAddEleGroup() throws SQLException{
		group = this.dataElementService.addSqlDataElement("CHiQ三看", "select time as '对应时间',category as '分类',contain_store_tv,modes as '统计方式',content/3600 as '时长(小时)',create_time as '创建时间',update_time as '更新时间' from chiq_watch_time_analy", "01");
	}
	/**
	 * 测试删除数据元素
	 */
	@After
	public void testDeleteGroup(){
		if(null!=group){
			this.dataElementService.deleteSqlDataElement(group.getId());
		}
	}
}

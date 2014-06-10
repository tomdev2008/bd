package com.changhong.bd.data.test.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.changhong.bd.core.runner.AbstractTestRunner;
import com.changhong.bd.data.domain.DbTableDto;
import com.changhong.bd.data.domain.TableColumnDto;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.BdDataSourceFactory;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DbStructureService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 上下文单元测试：数据结构服务
 */
public class TestForStructureService extends AbstractTestRunner {

	@Autowired
	@Qualifier("bdDataSourceFactory")
	private BdDataSourceFactory bdDataSourceFactory;
	
	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	
	@Autowired
	private DbStructureService dbStructureService;
	
	private RepositoryEntity entity = new RepositoryEntity();
	
	@Before
	public void before(){
		entity.setDriver("com.mysql.jdbc.Driver");
		entity.setUrl("jdbc:mysql://localhost:3306/bd_weixin?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true");
		entity.setUsername("tony");
		entity.setPassword("123456");
	}
	/**
	 * 通过仓库和表名查询列信息
	 * @throws SQLException
	 */
	@Test
	public void testQueryRepTableColumns() throws SQLException{
		List<TableColumnDto> list = this.dbStructureService.queryColumns(entity, "bd_abs_tx_name");
		out(list);
		
		list = this.dbStructureService.queryColumns(entity, "2b");
		out(list);
		
	}
	/**
	 * 测试，通过entity获取数据库连接
	 * @throws SQLException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Test
	public void testGetDbStructure() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		
		Connection conn = this.bdDataSourceFactory.queryCollection(entity);
		try{
			DatabaseMetaData dmd = conn.getMetaData();
			String db = dmd.getDatabaseProductName();
			System.out.println(db);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		List<DbTableDto> tbs = this.dbStructureService.queryAllIndex(entity);
		out(tbs);
		for(DbTableDto d : tbs){
			List<TableColumnDto> colsDef = this.dbStructureService.queryColumns(d);
			out(colsDef);
		}
	}
}

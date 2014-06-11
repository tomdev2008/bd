package com.changhong.bd.data.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.data.domain.DbTableDto;
import com.changhong.bd.data.domain.TableColumnDto;
import com.changhong.bd.data.entity.DataRepositoryEntity;
import com.changhong.bd.data.service.api.BdDataSourceFactory;
import com.changhong.bd.data.service.api.DataDefinitionStoreService;
import com.changhong.bd.data.service.api.DbStructureService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 加载上下文的单元测试
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml"
})
public class ContextTest extends AbstractJUnit4SpringContextTests {

	private static Logger logger = LoggerFactory.getLogger(ContextTest.class);
	@Autowired
	@Qualifier("bdDataSourceFactory")
	private BdDataSourceFactory bdDataSourceFactory;
	
	@Autowired
	private DataDefinitionStoreService dataDefinitionStoreService;
	
	@Autowired
	private DbStructureService dbTableService;
	
	private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 测试，通过entity获取数据库连接
	 * @throws SQLException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Test
	public void testGetDbStructure() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
		DataRepositoryEntity entity = new DataRepositoryEntity();
		entity.setDriver("com.mysql.jdbc.Driver");
		entity.setUrl("jdbc:mysql://localhost:3306/bd_weixin?createDatabaseIfNotExist=true&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true");
		entity.setUsername("tony");
		entity.setPassword("123456");
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
		
		List<DbTableDto> tbs = this.dbTableService.queryAllIndex(entity);
		for(DbTableDto d : tbs){
			String s = objectMapper.writeValueAsString(d);
			System.out.println(s);
		}
		for(DbTableDto d : tbs){
			List<TableColumnDto> colsDef = this.dbTableService.queryColumns(d);
			logger.info("table:{}, cols size:{}", d.getTableName(), colsDef.size());
		}
		
		
	}
}

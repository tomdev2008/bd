package com.changhong.bd.data.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.changhong.bd.data.domain.DataElementDto;
import com.changhong.bd.data.domain.DbTableDto;
import com.changhong.bd.data.domain.TableColumnDto;
import com.changhong.bd.data.entity.DataElementEntity;
import com.changhong.bd.data.entity.DataElementGroupEntity;
import com.changhong.bd.data.entity.RepositoryEntity;
import com.changhong.bd.data.service.api.BdDataSourceFactory;
import com.changhong.bd.data.service.api.DbStructureService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 
 */
@Service("dbStructureService")
@Transactional(readOnly=true)
public class DbStructureServiceImpl implements DbStructureService{
	@Autowired
	private BdDataSourceFactory bdDataSourceFactory;
	
	private static Logger logger = LoggerFactory.getLogger(DbStructureServiceImpl.class);
	
	@Override
	public List<DataElementDto> queryDateElement(DataElementGroupEntity group) throws SQLException{
		RepositoryEntity rep = group.getRep();
		Statement statement = this.bdDataSourceFactory.queryStatement(rep);
		ResultSet rs = statement.executeQuery(group.getProcessLanguage());
		ResultSetMetaData metaData = rs.getMetaData();
		
		Integer columnSize = metaData.getColumnCount();
		
		List<DataElementDto> listd = new ArrayList<DataElementDto>();
		for(int i=1;i<=columnSize;i++){
			//单数据元素
			DataElementEntity dee = new DataElementEntity();
			
			String tableCatalog = metaData.getCatalogName(i);
			dee.setTableCatalog(tableCatalog);
			
			String columnClassName = metaData.getColumnClassName(i);
			dee.setColumnClassName(columnClassName);
			
			int columnDisplaySize = metaData.getColumnDisplaySize(i);
			dee.setColumnDisplaySize(columnDisplaySize);
			
			String columnLabel = metaData.getColumnLabel(i);
			dee.setColumnLabel(columnLabel);
			
			String columnName = metaData.getColumnName(i);
			dee.setColumnName(columnName);
			
			int columnType = metaData.getColumnType(i);
			dee.setColumnType(columnType);
			
			String columnTypeName = metaData.getColumnTypeName(i);
			dee.setColumnTypeName(columnTypeName);
			
			int precision = metaData.getPrecision(i);
			dee.setPrecision(precision);
			
			int scale = metaData.getScale(i);
			dee.setScale(scale);
			
			String tableSchema = metaData.getSchemaName(i);
			dee.setTableSchema(tableSchema);
			
			String tableName = metaData.getTableName(i);
			dee.setTableName(tableName);
			
			//TODO
			//listd.add(dee);
		}
		return listd;
	}
	@Override
	public List<TableColumnDto> queryColumns(DbTableDto tableDomain){
		RepositoryEntity rep = tableDomain.getRep();
		Connection conn = this.bdDataSourceFactory.queryCollection(rep);
		String schema = rep.getSchema();
		String table = tableDomain.getTableName();
		List<TableColumnDto> list = new ArrayList<TableColumnDto>();
		try {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet rs = meta.getColumns(null, schema, table, null);
			
			while(rs.next()){
				TableColumnDto t = new TableColumnDto();
				String tableCatalog = rs.getString("TABLE_CAT");
				t.setTableCatalog(tableCatalog);
				
				String tableSchema = rs.getString("TABLE_SCHEM");
				t.setTableSchema(tableSchema);
				
				String tableName = rs.getString("TABLE_NAME");
				t.setTableName(tableName);
				
				String columnName = rs.getString("COLUMN_NAME");
				t.setColumnName(columnName);
				
				Integer dataType = rs.getInt("DATA_TYPE");
				t.setDataType(dataType);
				
				String typeName = rs.getString("TYPE_NAME");
				t.setTypeName(typeName);
				
				Integer columnSize = rs.getInt("COLUMN_SIZE");
				t.setColumnSize(columnSize);
				
				Integer decimalDigits = rs.getInt("DECIMAL_DIGITS");
				t.setDecimalDigits(decimalDigits);
				
				Integer numPrecRadix = rs.getInt("NUM_PREC_RADIX");
				t.setNumPrecRadix(numPrecRadix);
				
				Integer nullable = rs.getInt("NULLABLE");
				t.setNullable(nullable);
				
				String remarks = rs.getString("REMARKS");//comment
				t.setRemarks(remarks);
				
				String columnDefualt = rs.getString("COLUMN_DEF");
				t.setColumnDefualt(columnDefualt);
				
				Integer charOctetLength = rs.getInt("CHAR_OCTET_LENGTH");
				t.setCharOctetLength(charOctetLength);
				
				Integer ordinalPosition = rs.getInt("ORDINAL_POSITION"); //index start at 1
				t.setOrdinalPosition(ordinalPosition);
				
				String isNullable = rs.getString("IS_NULLABLE");
				t.setIsNullable(isNullable);
				
				String scopeCatalog = rs.getString("SCOPE_CATALOG");
				t.setScopeCatalog(scopeCatalog);
				
				String scopeSchema = rs.getString("SCOPE_SCHEMA");
				t.setScopeSchema(scopeSchema);
				
				String scopeTable = rs.getString("SCOPE_TABLE");
				t.setScopeTable(scopeTable);
				
				Short sourceDataType = rs.getShort("SOURCE_DATA_TYPE");
				t.setSourceDataType(sourceDataType);
				
				String isAutocrement = rs.getString("IS_AUTOINCREMENT");
				t.setIsAutocrement(isAutocrement);
				
				list.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("query schema:{} table:{} 's columns fail.", schema, table);
		}
		
		return list;
	}
	
	@Override
	public List<DbTableDto> queryAllIndex(RepositoryEntity rep) throws SQLException {
		Connection conn = this.bdDataSourceFactory.queryCollection(rep);
		
		List<DbTableDto> list = new ArrayList<DbTableDto>();
		try {
			String repSchema = rep.getSchema();
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet rs = meta.getTables(null, repSchema, null, new String[]{"VIEW", "TABLE"});
			while(rs.next()){
				String tableCatalog = rs.getString("TABLE_CAT");
				String tableSchema = rs.getString("TABLE_SCHEM");
				String tableName = rs.getString("TABLE_NAME");
				String tableType = rs.getString("TABLE_TYPE");//"TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM"
				String tableRemarks = rs.getString("REMARKS");
				
				DbTableDto d = new DbTableDto( 
						rep,
						tableCatalog, 
						 tableSchema,
						 tableName,
						 tableType,
						 tableRemarks);
				
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return list;
	}
	@Override
	public List<TableColumnDto> queryColumns(RepositoryEntity rep, String tableName) throws SQLException {
		Connection conn = this.bdDataSourceFactory.queryCollection(rep);
		
		List<DbTableDto> list = new ArrayList<DbTableDto>();
		try {
			String repSchema = rep.getSchema();
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet rs = meta.getTables(null, repSchema, tableName, new String[]{"VIEW", "TABLE"});
			while(rs.next()){
				String tableCatalog = rs.getString("TABLE_CAT");
				String tableSchema = rs.getString("TABLE_SCHEM");
				String tableType = rs.getString("TABLE_TYPE");//"TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM"
				String tableRemarks = rs.getString("REMARKS");
				
				DbTableDto d = new DbTableDto( 
						rep,
						tableCatalog, 
						 tableSchema,
						 tableName,
						 tableType,
						 tableRemarks);
				
				list.add(d);
			}
		} finally{
			conn.close();
		}
		
		if(list.size()>0){
			return this.queryColumns(list.get(0));
		}
		
		return null;
	}

}

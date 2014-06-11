package com.changhong.bd.data.domain;

import java.io.Serializable;

import com.changhong.bd.data.entity.DataRepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月21日
 * @version 1.0
 * @description : 数据库 表/视图 信息
 */
public class DbTableDto implements Serializable{

	private static final long serialVersionUID = 8870820379196084010L;

	//所属仓库
	private DataRepositoryEntity rep;
	private String tableCatalog = "";
	private String tableSchema = "";
	private String tableName = "";
	private String tableType = "";
	private String tableRemarks = "";
	
	public DbTableDto(){
		super();
	}
	public DbTableDto(
			DataRepositoryEntity rep,
			String tableCatalog, 
			String tableSchema,
			String tableName,
			String tableType,
			String tableRemarks) {
		super();
		this.rep = rep;
		this.tableCatalog = tableCatalog;
		this.tableSchema = tableSchema;
		this.tableName = tableName;
		this.tableType = tableType;
		this.tableRemarks = tableRemarks;
	}
	public String getTableCatalog() {
		return tableCatalog;
	}
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public String getTableRemarks() {
		return tableRemarks;
	}
	public void setTableRemarks(String tableRemarks) {
		this.tableRemarks = tableRemarks;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public DataRepositoryEntity getRep() {
		return rep;
	}
	public void setRep(DataRepositoryEntity rep) {
		this.rep = rep;
	}
	
	
}

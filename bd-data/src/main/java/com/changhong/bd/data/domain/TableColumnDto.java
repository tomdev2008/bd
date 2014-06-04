package com.changhong.bd.data.domain;

import java.io.Serializable;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月22日
 * @version 1.0
 * @description : 数据库表字段
 */
public class TableColumnDto implements Serializable{

	private static final long serialVersionUID = -8859606013042366011L;

	private String tableCatalog;
	private String tableSchema;
	private String tableName;
	private String columnName;
	private Integer dataType;
	private String typeName;
	private Integer columnSize;
	private Integer decimalDigits;
	private Integer numPrecRadix;
	private Integer nullable;
	private String remarks;
	private String columnDefualt;
	private Integer charOctetLength;
	private Integer ordinalPosition;
	private String isNullable;
	private String scopeCatalog;
	private String scopeSchema;
	private String scopeTable;
	private Short sourceDataType;
	private String isAutocrement;
	
	
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
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}
	public Integer getDecimalDigits() {
		return decimalDigits;
	}
	public void setDecimalDigits(Integer decimalDigits) {
		this.decimalDigits = decimalDigits;
	}
	public Integer getNumPrecRadix() {
		return numPrecRadix;
	}
	public void setNumPrecRadix(Integer numPrecRadix) {
		this.numPrecRadix = numPrecRadix;
	}
	public Integer getNullable() {
		return nullable;
	}
	public void setNullable(Integer nullable) {
		this.nullable = nullable;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getColumnDefualt() {
		return columnDefualt;
	}
	public void setColumnDefualt(String columnDefualt) {
		this.columnDefualt = columnDefualt;
	}
	public Integer getCharOctetLength() {
		return charOctetLength;
	}
	public void setCharOctetLength(Integer charOctetLength) {
		this.charOctetLength = charOctetLength;
	}
	public Integer getOrdinalPosition() {
		return ordinalPosition;
	}
	public void setOrdinalPosition(Integer ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getScopeCatalog() {
		return scopeCatalog;
	}
	public void setScopeCatalog(String scopeCatalog) {
		this.scopeCatalog = scopeCatalog;
	}
	public String getScopeSchema() {
		return scopeSchema;
	}
	public void setScopeSchema(String scopeSchema) {
		this.scopeSchema = scopeSchema;
	}
	public String getScopeTable() {
		return scopeTable;
	}
	public void setScopeTable(String scopeTable) {
		this.scopeTable = scopeTable;
	}
	public Short getSourceDataType() {
		return sourceDataType;
	}
	public void setSourceDataType(Short sourceDataType) {
		this.sourceDataType = sourceDataType;
	}
	public String getIsAutocrement() {
		return isAutocrement;
	}
	public void setIsAutocrement(String isAutocrement) {
		this.isAutocrement = isAutocrement;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

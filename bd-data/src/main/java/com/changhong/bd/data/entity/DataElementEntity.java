package com.changhong.bd.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月23日
 * @version 1.0
 * @description : 数据元素
 */
@Entity
@Table(name="data_data_ele")
public class DataElementEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 2698836123876350041L;

	//所属数据集
	@ManyToOne
	@JoinColumn(name="groupid")
	private DataElementGroupEntity group;
	
	@Column(name="tablecatalog")
	private String tableCatalog;
	
	@Column(name="columnclassname")
	private String columnClassName;

	@Column(name="columndisplaysize")
	private int columnDisplaySize;

	@Column(name="columnlabel")
	private String columnLabel;

	@Column(name="columnname")
	private String columnName;

	@Column(name="columntype")
	private int columnType;

	@Column(name="columntypename")
	private String columnTypeName;

	@Column(name="precision")
	private int precision;

	@Column(name="scale")
	private int scale;

	@Column(name="tableschema")
	private String tableSchema;

	@Column(name="tablename")
	private String tableName;

	public DataElementGroupEntity getGroup() {
		return group;
	}

	public void setGroup(DataElementGroupEntity group) {
		this.group = group;
	}

	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	public String getColumnClassName() {
		return columnClassName;
	}

	public void setColumnClassName(String columnClassName) {
		this.columnClassName = columnClassName;
	}

	public int getColumnDisplaySize() {
		return columnDisplaySize;
	}

	public void setColumnDisplaySize(int columnDisplaySize) {
		this.columnDisplaySize = columnDisplaySize;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public int getColumnType() {
		return columnType;
	}

	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}

	public String getColumnTypeName() {
		return columnTypeName;
	}

	public void setColumnTypeName(String columnTypeName) {
		this.columnTypeName = columnTypeName;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
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
	
}

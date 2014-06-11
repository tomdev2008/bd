package com.changhong.bd.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月20日
 * @version 1.0
 * @description : 数据仓库
 */
@Entity
@Table(name="data_repository")
public class DataRepositoryEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 6570950348100915699L;

	@Column(name="rep_driver")
	private String driver = "";
	
	@Column(name="rep_url")
	private String url = "";
	
	@Column(name="rep_username")
	private String username = "";
	
	@Column(name="rep_password")
	private String password = "";
	
	@Column(name="rep_schema")
	private String schema = "";
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

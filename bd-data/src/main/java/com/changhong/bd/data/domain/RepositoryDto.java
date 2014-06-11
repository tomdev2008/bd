package com.changhong.bd.data.domain;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.changhong.bd.data.entity.DataRepositoryEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 数据仓库数据传输对象
 */
public class RepositoryDto extends AbsTxNameEntity{

	private static final long serialVersionUID = 4499122662694002825L;

	private String driver = "";
	
	private String url = "";
	
	private String username = "";
	
	private String schema = "";

	public RepositoryDto() {
	}	
	public RepositoryDto(DataRepositoryEntity rep) {
		super(rep);
		this.driver = rep.getDriver();
		this.url = rep.getUrl();
		this.username = rep.getUsername();
		this.schema = rep.getSchema();
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

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
}

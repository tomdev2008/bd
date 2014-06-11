package com.changhong.bd.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月11日
 * @version 1.0
 * @description : 数据报表
 */
@Entity
@Table(name="data_reporter")
public class DataReporterEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -7237183398263487598L;

	/**
	 * UI组件的配置信息
	 */
	@Column(name="uiconfig")
	private String uiconfig = "";
	
	/**
	 * 数据组件的配置信息
	 */
	@Column(name="dataconfig")
	private String dataconfig = "";

	//用户信息
	@Column(name="userid")
	private String userId = "";
	
	@Column(name="username")
	private String userName = "";
	/**
	 * 公开访问地址
	 */
	@Column(name="shareid")
	private String shareId = "";
	
	public String getUiconfig() {
		return uiconfig;
	}

	public void setUiconfig(String uiconfig) {
		this.uiconfig = uiconfig;
	}

	public String getDataconfig() {
		return dataconfig;
	}

	public void setDataconfig(String dataconfig) {
		this.dataconfig = dataconfig;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	
}

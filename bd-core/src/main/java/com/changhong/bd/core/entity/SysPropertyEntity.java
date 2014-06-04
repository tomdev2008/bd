package com.changhong.bd.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 系统参数配置
 */
@Entity
@Table(name="bd_sys_property")
public class SysPropertyEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -3812101064948686550L;

	/**
	 *属性值的名称 
	 */
	@Column(name="propertyname", nullable=false)
	private String propertyName = "";
	
	/**
	 * 属性值
	 */
	@Column(name="propertyvalue")
	private String propertyValue = "";

	/**
	 * appid 代码
	 */
	@Column(name="appid")
	private String appId = "";

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	
}

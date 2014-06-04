package com.changhong.bd.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsAuthEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 权限控制 - 按钮
 */
@Entity
@Table(name="bd_sys_auth_btn")
public class SysAuthButtonEntity extends AbsAuthEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065289907853874611L;

	@ManyToOne
	@JoinColumn(name="catalogid")
	private SysAuthButtonCatalogEntity catalog;

	public SysAuthButtonCatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(SysAuthButtonCatalogEntity catalog) {
		this.catalog = catalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

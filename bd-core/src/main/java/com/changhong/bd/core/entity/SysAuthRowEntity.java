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
 * @description : 权限认证，行级权限
 */
@Entity
@Table(name="bd_sys_auth_row")
public class SysAuthRowEntity extends AbsAuthEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4345876007069854903L;

	@ManyToOne
	@JoinColumn(name="catalogid")
	private SysAuthRowCatalogEntity catalog;

	public SysAuthRowCatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(SysAuthRowCatalogEntity catalog) {
		this.catalog = catalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

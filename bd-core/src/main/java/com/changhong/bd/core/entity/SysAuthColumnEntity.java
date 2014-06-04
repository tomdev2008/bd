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
 * @description : 权限管控 - 列级权限
 */
@Entity
@Table(name="bd_sys_auth_column")
public class SysAuthColumnEntity extends AbsAuthEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6429112913652105968L;

	@ManyToOne
	@JoinColumn(name="catalogid")
	private SysAuthColumnCatalogEntity catalog;

	public SysAuthColumnCatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(SysAuthColumnCatalogEntity catalog) {
		this.catalog = catalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

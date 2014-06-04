package com.changhong.bd.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsAuthEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月9日
 * @version 1.0
 * @description : 权限认证 - 菜单权限
 */
@Entity
@Table(name="bd_sys_auth_menu")
public class SysAuthMenuEntity extends AbsAuthEntity{

	private static final long serialVersionUID = -6070910354169438293L;

	@ManyToOne
	@JoinColumn(name="catalogid")
	private SysAuthMenuCatalogEntity catalog;
	
	/**
	 * 菜单类型  <br/>
	 * 	<p>1 普通requirejs菜单  
 	 *  <p>10 iframe 菜单
	 */
	@Column(name="menutype")
	private Integer menuType;
	
	/**
	 * 菜单值
	 */
	@Column(name="value")
	private String value;

	public SysAuthMenuCatalogEntity getCatalog() {
		return catalog;
	}

	public void setCatalog(SysAuthMenuCatalogEntity catalog) {
		this.catalog = catalog;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}

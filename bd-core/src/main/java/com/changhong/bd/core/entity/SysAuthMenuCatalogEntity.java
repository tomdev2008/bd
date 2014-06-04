package com.changhong.bd.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 菜单权限目录 
 */
@Entity
@Table(name="bd_sys_auth_menu_catalog")
public class SysAuthMenuCatalogEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -8817095987859207206L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parentid")
	private SysAuthMenuCatalogEntity parent;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="parentid")
	private Set<SysAuthMenuCatalogEntity> children = new HashSet<SysAuthMenuCatalogEntity>();
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="catalogid")
	private Set<SysAuthMenuEntity> menus = new HashSet<SysAuthMenuEntity>();

	public SysAuthMenuCatalogEntity getParent() {
		return parent;
	}

	public void setParent(SysAuthMenuCatalogEntity parent) {
		this.parent = parent;
	}

	public Set<SysAuthMenuCatalogEntity> getChildren() {
		return children;
	}

	public void setChildren(Set<SysAuthMenuCatalogEntity> children) {
		this.children = children;
	}

	public Set<SysAuthMenuEntity> getMenus() {
		return menus;
	}

	public void setMenus(Set<SysAuthMenuEntity> menus) {
		this.menus = menus;
	}

	
	
}

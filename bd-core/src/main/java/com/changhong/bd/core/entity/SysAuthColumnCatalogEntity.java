package com.changhong.bd.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月12日
 * @version 1.0
 * @description : 权限认证 列级权限 目录
 */
@Entity
@Table(name="bd_sys_auth_column_catalog")
public class SysAuthColumnCatalogEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 228077018653213717L;

	@Column(name="parentid")
	private String parentId;
	
	@OneToMany
	@JoinColumn(name="catalogid")
	private Set<SysAuthColumnEntity> columns = new HashSet<SysAuthColumnEntity>();

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Set<SysAuthColumnEntity> getColumns() {
		return columns;
	}

	public void setColumns(Set<SysAuthColumnEntity> columns) {
		this.columns = columns;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

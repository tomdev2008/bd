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
 * @description : 行级权限目录
 */
@Entity
@Table(name="bd_sys_auth_row_catalog")
public class SysAuthRowCatalogEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -5526863302369661308L;
	
	@Column(name="parentid", length=32)
	private String parentId;

	@OneToMany
	@JoinColumn(name="catalogid")
	private Set<SysAuthRowEntity> authRows = new HashSet<SysAuthRowEntity>();
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

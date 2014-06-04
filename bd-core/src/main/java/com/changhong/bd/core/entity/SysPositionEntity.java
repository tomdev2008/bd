package com.changhong.bd.core.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 * 	系统职位，职位仅仅用于鉴权。
 * 	不用于存数，存数是组织机构的事情。
 * 	原因：权限不提供数据权限管控，组织机构树状结构可以提供。
 */
@Entity
@Table(name="bd_sys_position")
public class SysPositionEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -1755959078775656270L;

	@Column(name="orgid", length=32)
	private String orgId = "";
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_account_position",
		joinColumns={@JoinColumn(name="positionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="accountid",referencedColumnName="id")})
	private Set<SysAccountEntity> accounts = new HashSet<SysAccountEntity>();
	
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_position_authbtn",
		joinColumns={@JoinColumn(name="positionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="buttonid",referencedColumnName="id")})
	private Set<SysAuthButtonEntity> authButtons = new HashSet<SysAuthButtonEntity>();
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_position_authmenu",
		joinColumns={@JoinColumn(name="positionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="menuid",referencedColumnName="id")})
	private Set<SysAuthMenuEntity> authMenus = new HashSet<SysAuthMenuEntity>();
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_position_authrow",
		joinColumns={@JoinColumn(name="positionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="rowid",referencedColumnName="id")})
	private Set<SysAuthRowEntity> authRow = new HashSet<SysAuthRowEntity>();
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_position_authcolumn",
		joinColumns={@JoinColumn(name="positionid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="columnid",referencedColumnName="id")})
	private Set<SysAuthColumnEntity> authColumn = new HashSet<SysAuthColumnEntity>();

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public List<SysAuthButtonEntity> getAuthButtons() {
		List<SysAuthButtonEntity> list = new ArrayList<SysAuthButtonEntity>(authButtons);
		return list;
	}

	public void setAuthButtons(Set<SysAuthButtonEntity> authButtons) {
		this.authButtons = authButtons;
	}

	public List<SysAuthMenuEntity> getAuthMenus() {
		List<SysAuthMenuEntity> list = new ArrayList<SysAuthMenuEntity>(authMenus);
		return list;
	}

	public void setAuthMenus(Set<SysAuthMenuEntity> authMenus) {
		this.authMenus = authMenus;
	}

	public List<SysAuthRowEntity> getAuthRow() {
		List<SysAuthRowEntity> list = new ArrayList<SysAuthRowEntity>(authRow);
		return list;
	}

	public void setAuthRow(Set<SysAuthRowEntity> authRow) {
		this.authRow = authRow;
	}

	public List<SysAuthColumnEntity> getAuthColumn() {
		List<SysAuthColumnEntity> list = new ArrayList<SysAuthColumnEntity>(authColumn);
		return list;
	}

	public void setAuthColumn(Set<SysAuthColumnEntity> authColumn) {
		this.authColumn = authColumn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

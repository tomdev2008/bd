package com.changhong.bd.core.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 系统操作用户
 */
@Entity
@Table(name="bd_sys_account")
public class SysAccountEntity extends AbsTxNameEntity {

	private static final long serialVersionUID = -6118022543141137770L;

	@Column(name="loginname", unique=true)
	private String loginName = "";
	
	@Column(name="password", length=128)
	private String password = "";//密码
	
	@OneToOne
	@JoinColumn(name="userid",unique=true)
	private SysUserEntity sysUser;
	
	@Column(name="salt", updatable=false)
	private String salt;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="bd_account_position",
		joinColumns={@JoinColumn(name="accountid",referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="positionid",referencedColumnName="id")})
	private Set<SysPositionEntity> positions;

	//明文密码，不持久化
	@Transient
	private String plainPassword;
	
	public SysAccountEntity(){
		
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SysUserEntity getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUserEntity sysUser) {
		this.sysUser = sysUser;
	}

	public Set<SysPositionEntity> getPositions() {
		return positions;
	}

	public void setPositions(Set<SysPositionEntity> positions) {
		this.positions = positions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	
	
}

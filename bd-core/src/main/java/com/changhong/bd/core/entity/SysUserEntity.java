package com.changhong.bd.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.changhong.bd.core.domain.SysUserDto;
import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 员工
 */
@Entity
@Table(name="bd_sys_user")
public class SysUserEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = 6134579955985580458L;

	@Column(name="userid", unique=true, length=128)
	private String userId;//员工号,唯一
	
	@Column(name="email", length=18)
	private String email;//电子邮箱
	
	@Column(name="phone", length=32)
	private String phone;//电话号码

	@Column(name="address")
	private String address;//住址
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="regionid")
	private SysRegionEntity region = new SysRegionEntity();//所属区域
	
	public SysUserEntity(){
		
	}
	public SysUserEntity(SysUserDto dto) {
		super(dto);
		this.userId = dto.getUserId();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
		this.address = dto.getAddress();
		this.region.setId(dto.getRegionId());
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public SysRegionEntity getRegion() {
		return region;
	}

	public void setRegion(SysRegionEntity region) {
		this.region = region;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

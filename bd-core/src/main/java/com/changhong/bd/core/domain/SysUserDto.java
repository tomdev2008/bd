package com.changhong.bd.core.domain;

import com.changhong.bd.core.entity.SysRegionEntity;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月26日
 * @version 1.0
 * @description : 用户对象dto
 */
public class SysUserDto extends AbsTxNameEntity{

	private static final long serialVersionUID = 4530015826113743745L;

	private String userId;//员工号,唯一
	
	private String email;//电子邮箱
	
	private String phone;//电话号码

	private String address;//住址
	
	private String regionId;
	private String regionName;
	
	public SysUserDto(){
		
	}
	public SysUserDto(SysUserEntity e){
		super(e);
		this.userId = e.getUserId();
		this.email = e.getEmail();
		this.phone = e.getPhone();
		this.address = e.getAddress();
		SysRegionEntity re = e.getRegion();
		this.regionId = re.getId();
		this.regionName = re.getName();
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
	

	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

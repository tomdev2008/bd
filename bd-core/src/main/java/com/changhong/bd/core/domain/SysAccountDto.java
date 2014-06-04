package com.changhong.bd.core.domain;

import com.changhong.bd.core.entity.SysAccountEntity;
import com.changhong.bd.core.entity.SysUserEntity;
import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月14日
 * @version 1.0
 * @description : 用于映射 ${link com.changhong.bd.core.entity.SysAccount}
 */
public class SysAccountDto extends AbsTxNameEntity{

	private static final long serialVersionUID = 2345874486789096310L;
	private String loginName = "";
	private String plainPassword = "";
	private String userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	
	public SysAccountDto(){
		
	}
	public SysAccountDto(SysAccountEntity e){
		super(e);
		SysUserEntity user = e.getSysUser();
		
		this.userEmail = user.getEmail();
		this.userId = user.getId();
		this.userName = user.getName();
		this.userPhone = user.getPhone();
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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

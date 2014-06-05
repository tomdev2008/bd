package com.changhong.bd.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsTxEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月13日
 * @version 1.0
 * @description : 绑定社交账户
 */
@Entity
@Table(name="social_bind")
public class SocialBind extends AbsTxEntity{

	private static final long serialVersionUID = 9141368988489980678L;

	@Column(name="bindtype", length=32, nullable=false)
	private String bindType;//绑定类型  - QQ Wechat Weibo 待补充
	
	@Column(name="openid", length=93, nullable=false)
	private String openId;
	
	@Column(name="accountid", length=32, nullable=false)
	private String accountId;

	public SocialBind(){
		
	}
	public SocialBind(String bindType, String openId, String accountId){
		this.bindDate = new DateTime();
		this.bindType = bindType;
		this.openId = openId;
		this.accountId = accountId;
	}
	/**
	 * 绑定时间
	 */
	@Column(name="binddate")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime bindDate = new DateTime();
	
	public DateTime getBindDate() {
		return bindDate;
	}

	public void setBindDate(DateTime bindDate) {
		this.bindDate = bindDate;
	}

	public String getBindType() {
		return bindType;
	}

	public void setBindType(String bindType) {
		this.bindType = bindType;
	}


	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

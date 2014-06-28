package com.changhong.bd.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * wechat qrcode entity
 * @author Sunrui
 * @date 2014年6月28日
 */
@Entity
@Table(name="social_wechat_qrcode")
public class WechatQrcodeEntity extends AbsEntity{

	private static final long serialVersionUID = 5072943605436659538L;

	
	@Column(name="codetype")
	private String codeType = "";
	
	@Column(name="codeinfo")
	private String codeInfo = "";
	
	@Column(name="wechatopenid")
	private String wechatOpenId = "";

	@Column(name="createtime")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createTime = new DateTime();
	
	@Column(name="expiretime")
	private Integer expireTime = 0;
	
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeInfo() {
		return codeInfo;
	}

	public void setCodeInfo(String codeInfo) {
		this.codeInfo = codeInfo;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}
	
	
}

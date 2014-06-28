package com.changhong.bd.social.domain;

import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsEntity;
import com.changhong.bd.social.entity.WechatQrcodeEntity;
/**
 * 
 * @author Sunrui
 * @date 2014年6月28日
 */
public class WechatQrcodeDto  extends AbsEntity{

	private static final long serialVersionUID = -171667438762464896L;

	public WechatQrcodeDto(){
		
	}
	public WechatQrcodeDto(WechatQrcodeEntity e){
		super(e);
		this.codeInfo = e.getCodeInfo();
		this.codeType = e.getCodeType();
		this.wechatOpenId = e.getWechatOpenId();
		this.createTime = e.getCreateTime();
		this.expireTime = e.getExpireTime();
	}
	private String codeType = "";
	
	private String codeInfo = "";
	
	private String wechatOpenId = "";
	
	private DateTime createTime = new DateTime();
	
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

package com.changhong.bd.pay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月13日
 * @version 1.0
 * @description :微信告警记录 
 */
@Entity
@Table(name="pay_wechat_alarm")
public class WechatAlarmEntity 
	extends AbsEntity{

	private static final long serialVersionUID = 8977652606782250097L;

	private String appId;
	private String errorType;
	private String description;
	private String alarmContent;
	private String timeStamp;
	private String appSignature;
	private String signMethod;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAppSignature() {
		return appSignature;
	}
	public void setAppSignature(String appSignature) {
		this.appSignature = appSignature;
	}
	public String getSignMethod() {
		return signMethod;
	}
	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}
	
	
}

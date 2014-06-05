package com.changhong.bd.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 微信信息，记录信息
 */
@Entity
@Table(name="social_wechat_message")
public class SocialWechatMessage extends AbsEntity {

	private static final long serialVersionUID = 5581475878116946552L;

	@Column(name="openid", length=128, nullable=false) //不同的社交场景，不同的ID长度，暂定128位
	private String openId;
	
	//操作用户的ID
	@Column(name="userid", length=32)
	private String userId = "";
	
	@Column(name="indate")
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private DateTime inDate = new DateTime();
	
	//4个消息字段，可能为空的
	@Column(name="inmessage")
	private String inMessage = "";//用户发送过来的数据，大数据字段, json序列化
	
	@Column(name="inmessagetype")
	private String inMessageType = "TEXT";//进来的信息的类型
	
	@Column(name="outmessage")
	private String outMessage = "";//发送出去的数据，大数据字段,json序列化

	@Column(name="outmessagetype")
	private String outMessageType = "TEXT";//发送出去的消息的类型
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public DateTime getInDate() {
		return inDate;
	}

	public void setInDate(DateTime inDate) {
		this.inDate = inDate;
	}

	public String getInMessage() {
		return inMessage;
	}

	public void setInMessage(String inMessage) {
		this.inMessage = inMessage;
	}

	public String getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}

	public String getInMessageType() {
		return inMessageType;
	}

	public void setInMessageType(String inMessageType) {
		this.inMessageType = inMessageType;
	}

	public String getOutMessageType() {
		return outMessageType;
	}

	public void setOutMessageType(String outMessageType) {
		this.outMessageType = outMessageType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package com.changhong.bd.social.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 微信当前频道
 */
@Entity
@Table(name="social_wechat_channel")
public class WechatChannelEntity extends AbsTxNameEntity{

	private static final long serialVersionUID = -3399340066420200541L;

	//open id
	@Column(name="wechatopenid")
	private String wechatOpenId;
	
	//频道id
	@Column(name="wechatchannelid")
	private String wechatChannelId;
	
	//频道名称
	@Column(name="wechatchanelname")
	private String wechatChannelName;
	
	//给各个模块自主存放信息的
	@Column(name="channelinfo")
	private String channelInfo;
	
	//消息进入时间
	@Column(name="intime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime inTime;
	
	//消息过期时间
	@Column(name="expiretime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime expireTime;
	
	public WechatChannelEntity(
			String name,
			String wechatOpenId, 
			String wechatChannelId, 
			String wechatChannelName, 
			String channelInfo) {
		super();
		this.setName(name);
		this.wechatOpenId = wechatOpenId;
		this.wechatChannelId = wechatChannelId;
		this.wechatChannelName = wechatChannelName;
		this.channelInfo = channelInfo;
		
		this.initTime();
	}

	private void initTime(){

		DateTime current = new DateTime();
		inTime = current.minusMinutes(1);
		//有效期30分钟
		expireTime = current.plusMinutes(30);
	}
	public WechatChannelEntity(){
		this.initTime();
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public String getWechatChannelId() {
		return wechatChannelId;
	}

	public void setWechatChannelId(String wechatChannelId) {
		this.wechatChannelId = wechatChannelId;
	}

	public String getWechatChannelName() {
		return wechatChannelName;
	}

	public void setWechatChannelName(String wechatChannelName) {
		this.wechatChannelName = wechatChannelName;
	}

	public DateTime getInTime() {
		return inTime;
	}

	public void setInTime(DateTime inTime) {
		this.inTime = inTime;
	}

	public DateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(DateTime expireTime) {
		this.expireTime = expireTime;
	}

	public String getChannelInfo() {
		return channelInfo;
	}

	public void setChannelInfo(String channelInfo) {
		this.channelInfo = channelInfo;
	}
	
	
}

package com.changhong.bd.social.domain;

import org.joda.time.DateTime;

import com.changhong.bd.core.entity.abs.AbsTxNameEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月18日
 * @version 1.0
 * @description : 
 */
public class WechatChannelDto extends AbsTxNameEntity{

	private static final long serialVersionUID = -4889384404271558248L;

	private String wechatOpenId = "";
	
	private String wechatChannelId = "";
	
	//频道名称
	private String wechatChannelName = "";

	private String channelInfo = "";
	//消息进入时间
	private DateTime inTime = new DateTime();
	
	//消息过期时间
	private DateTime expireTime = new DateTime();

	public WechatChannelDto(){
		
	}
	public WechatChannelDto(String openId, String channelId, String channelName, String channelInfo){
		this.wechatChannelId = openId;
		this.wechatChannelId = channelId;
		this.wechatChannelName = channelName;
		this.channelInfo = channelInfo;
		this.initTime();
	}
	private void initTime(){

		DateTime current = new DateTime();
		inTime = current.minusMinutes(1);
		//有效期30分钟
		expireTime = current.plusMinutes(30);
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

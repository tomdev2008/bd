package com.changhong.bd.social.domain;

import java.io.Serializable;
/**
 * 
 * @author Sunrui
 * @date 2014年6月28日
 */
public class WechatQrcodeImageDto implements Serializable{

	private static final long serialVersionUID = -2096461570088417344L;

	private String url = "";
	private Integer expireTime = 0;
	
	public WechatQrcodeImageDto (){
		
	}
	public WechatQrcodeImageDto(String url , Integer expireTime){
		this.url = url;
		this.expireTime = expireTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

}

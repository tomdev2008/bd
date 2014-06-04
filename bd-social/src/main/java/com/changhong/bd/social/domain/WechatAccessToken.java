package com.changhong.bd.social.domain;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description :
 */
public class WechatAccessToken {
	// 获取到的凭证
	private String token;
	// 凭证有效时间，单位：秒
	private int expiresIn;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}

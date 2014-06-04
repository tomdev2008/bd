package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信按钮基类
 */
public abstract class WechatBaseButton {

	private String name;

	public WechatBaseButton(){
		
	}
	public WechatBaseButton(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

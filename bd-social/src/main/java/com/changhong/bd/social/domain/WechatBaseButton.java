package com.changhong.bd.social.domain;

import java.io.Serializable;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信按钮基类
 */
public abstract class WechatBaseButton implements Serializable{

	private static final long serialVersionUID = 7076881614884131813L;

	//按钮名称
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

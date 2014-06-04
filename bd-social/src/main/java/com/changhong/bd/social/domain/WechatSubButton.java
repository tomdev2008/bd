package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信子菜单
 */
public class WechatSubButton extends WechatBaseButton {
	
	
	private String type;
	private String key;
	
	public WechatSubButton(){
		super();
	}
	public WechatSubButton(String name, String type, String key){
		super(name);
		this.type = type;
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}

package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信子菜单
 */
public class WechatSubClickButton extends WechatBaseButton {
	
	
	private static final long serialVersionUID = -5941189961724632824L;

	private String type = "click";
	private String key;
	
	public WechatSubClickButton(){
		super();
	}
	public WechatSubClickButton(String name, String key){
		super(name);
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

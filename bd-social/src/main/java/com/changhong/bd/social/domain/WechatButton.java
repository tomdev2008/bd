package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信一级菜单
 */
public class WechatButton extends WechatBaseButton{

	private static final long serialVersionUID = -754567645537941258L;

	public WechatButton(String name){
		super(name);
	}
	public WechatButton(){
		
	}
	//子菜单
	private WechatBaseButton[] sub_button;

	public WechatBaseButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(WechatBaseButton[] sub_button) {
		this.sub_button = sub_button;
	}
	
	
}

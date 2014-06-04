package com.changhong.bd.social.domain;
/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 微信一级菜单
 */
public class WechatButton extends WechatBaseButton{

	private WechatSubButton[] sub_button;

	public WechatSubButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(WechatSubButton[] sub_button) {
		this.sub_button = sub_button;
	}
	
	
}

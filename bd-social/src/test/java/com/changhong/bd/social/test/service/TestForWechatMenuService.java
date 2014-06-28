package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.domain.WechatAccessToken;
import com.changhong.bd.social.domain.WechatBaseButton;
import com.changhong.bd.social.domain.WechatButton;
import com.changhong.bd.social.domain.WechatMenu;
import com.changhong.bd.social.domain.WechatSubClickButton;
import com.changhong.bd.social.domain.WechatSubUrlButton;
import com.changhong.bd.social.service.api.WechatMenuService;
import com.changhong.bd.social.service.api.WechatTokenService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月22日
 * @version 1.0
 * @description : 
 */
public class TestForWechatMenuService 
	extends AbstractTestRunner{

	@Autowired
	private WechatMenuService wechatMenuService;
	
	@Autowired
	private WechatTokenService wechatTokenService;
	
	@Test
	public void testCreateMenu(){
//		out(this.createLotasteMenu());
		out("success");
	}
	
	@SuppressWarnings("unused")
	private Integer createLotasteMenu(){
		WechatAccessToken token = this.wechatTokenService.queryToken();
		
		WechatMenu menu = new WechatMenu();

		WechatSubClickButton info = new WechatSubClickButton("资讯","info_button");
		WechatButton more = new WechatButton("更多");

		WechatSubClickButton about = new WechatSubClickButton("关于", "about_lotaste");
		WechatSubClickButton twoDimCode = new WechatSubClickButton("二维码", "two_dim_code");
		WechatSubClickButton account = new WechatSubClickButton("我的账户","my_account");
		
		more.setSub_button(new WechatBaseButton[]{
			about, twoDimCode, account 
		});
		
		WechatSubUrlButton shopView = new WechatSubUrlButton("商城","http://lotaste.duapp.com/shop");
		
		WechatBaseButton[] buttons = new WechatBaseButton[]{
			shopView,info, more
		};
		menu.setButton(buttons);
		return this.wechatMenuService.createMenu(menu, token.getToken());

	}
}

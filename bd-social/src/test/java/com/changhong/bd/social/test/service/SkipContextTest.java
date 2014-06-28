package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.social.domain.WechatAccessToken;
import com.changhong.bd.social.domain.WechatBaseButton;
import com.changhong.bd.social.domain.WechatButton;
import com.changhong.bd.social.domain.WechatMenu;
import com.changhong.bd.social.domain.WechatSubClickButton;
import com.changhong.bd.social.service.api.WechatKeyService;
import com.changhong.bd.social.service.api.WechatMenuService;
import com.changhong.bd.social.service.api.WechatService;
import com.changhong.bd.social.service.api.WechatTokenService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 这里的测试，受到外部环境限制，不能每次编译，每次测试
 */
@ContextConfiguration(locations={
		"classpath*:/applicationContext.xml",
		"classpath*:/applicationContext-mail.xml",
		"classpath*:/applicationContext-spider.xml"
})
@SuppressWarnings("unused")
public class SkipContextTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private WechatTokenService wechatTokenService;
	@Autowired
	private WechatMenuService wechatMenuService;
	/**
	 * 进行菜单创建
	 */
	@Test
	public void testCreateMenu(){
//		WechatAccessToken wxToken = this.wechatTokenService.queryToken();
//		String token = wxToken.getToken();
//		this.wechatMenuService.createMenu(this.getMenu(), token);
		System.out.println("Skip test create Wechat Menu");
	}

	/**
	 * 创建菜单
	 * @return
	 */
	private WechatMenu getMenu() {
		WechatMenu menu = new WechatMenu();
		
		WechatSubClickButton service = new WechatSubClickButton("微信客服", "wechat_service");
		WechatSubClickButton spiderNews = new WechatSubClickButton("爬虫新闻", "spider_news");
		
		
		WechatButton btn1 = new WechatButton();
		
		btn1.setName("我");
		WechatSubClickButton sub1 = new WechatSubClickButton("账号绑定","bind_account");
		WechatSubClickButton sub2 = new WechatSubClickButton("商城","spider_shop");
		WechatSubClickButton sub3 = new WechatSubClickButton("自助保修","auto_help");
		
		btn1.setSub_button(new WechatSubClickButton[]{ sub1, sub2, sub3});
		
		menu.setButton(new WechatBaseButton[]{
			service,spiderNews,btn1
		});
		
		return menu;
	}
}
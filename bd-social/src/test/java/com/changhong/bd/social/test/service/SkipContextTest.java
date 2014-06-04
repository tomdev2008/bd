package com.changhong.bd.social.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.social.domain.WechatBaseButton;
import com.changhong.bd.social.domain.WechatButton;
import com.changhong.bd.social.domain.WechatMenu;
import com.changhong.bd.social.domain.WechatSubButton;
import com.changhong.bd.social.service.api.WechatService;

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
public class SkipContextTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private WechatService wechatService;
	/**
	 * 进行菜单创建
	 */
	@Test
	public void testCreateMenu(){
		//String ak[] = this.wechatService.queryAkSk();
		//WechatAccessToken wxToken = this.wechatService.queryToken(ak[0], ak[1]);
		//String token = wxToken.getToken();
		//this.wechatService.createMenu(this.getMenu(), token);
		System.out.println("Skip test create Wechat Menu");
	}

	/**
	 * 创建菜单
	 * @return
	 */
	@SuppressWarnings("unused")
	private WechatMenu getMenu() {
		WechatMenu menu = new WechatMenu();
		
		WechatButton btn1 = new WechatButton();
		btn1.setName("大数据");
		WechatSubButton sub1 = new WechatSubButton("新闻","click","wx_news");
		WechatSubButton sub2 = new WechatSubButton("报表","click","wx_reports");
		WechatSubButton sub3 = new WechatSubButton("关于","click","wx_about");
		btn1.setSub_button(new WechatSubButton[]{ sub1, sub2, sub3});
		
		WechatSubButton sub4 = new WechatSubButton("帮助","click","wx_help");
		menu.setButton(new WechatBaseButton[]{
			btn1,sub4
		});
		
		return menu;
	}
}
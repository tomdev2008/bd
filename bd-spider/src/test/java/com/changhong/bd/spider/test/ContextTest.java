package com.changhong.bd.spider.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;
import com.changhong.bd.spider.service.api.SpiderNewsService;
import com.changhong.bd.spider.service.api.SpiderRespService;
import com.changhong.bd.spider.wechat.WechatSpiderNewsPlugin;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@ContextConfiguration(locations={
		"classpath*:/applicationContext.xml",
		"classpath*:/applicationContext-mail.xml",
		"classpath*:/applicationContext-spider.xml"
})
public class ContextTest extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SpiderRespService spiderRespService;
	
	@Autowired
	private SpiderNewsService spiderNewsService;
	
	@Autowired
	private WechatSpiderNewsPlugin wechatSpiderNewsPlugin;
	
	/**
	 * 对爬虫新闻插件进行处理测试
	 */
	@Test
	public void testSpiderNewsPluginProcess(){
		TextInMessage msg = new TextInMessage();
		
		msg.setContent("Tony的名字");
		msg.setCreateTime(System.currentTimeMillis());
		msg.setFromUserName("from");
		msg.setMsgId(10000);
		msg.setMsgType(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT);
		msg.setToUserName("tony");
		
		String rep = this.wechatSpiderNewsPlugin.process(msg, null, "");
		logger.info(rep);
	}
	//对远端数据库进行远端新闻查询测试
	@Test
	public void testNewsQuery(){
		JsonPageData<SpiderClassifiedNews> jpd = this.spiderNewsService.query(1, 10, "诸神之战", null, null	);
		System.out.println(jpd.getCount());
	}
	@Test
	public void testServiceInject(){
		String hello = this.spiderRespService.hello();
		System.out.println(hello);
	}
}

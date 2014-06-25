package com.changhong.bd.spider.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.core.resp.JsonPageData;
import com.changhong.bd.core.service.api.SysAccountService;
import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.wechat.message.in.TextInMessage;
import com.changhong.bd.spider.entity.SpiderClassifiedNews;
import com.changhong.bd.spider.service.api.SpiderNewsService;
import com.changhong.bd.spider.service.api.SpiderRespService;
import com.changhong.bd.spider.wechat.WechatSpiderNewsPlugin;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
public class ContextTest extends AbstractTestRunner {
	
	@Autowired
	private SpiderRespService spiderRespService;
	
	@Autowired
	private SpiderNewsService spiderNewsService;
	
	@Autowired
	private WechatSpiderNewsPlugin wechatSpiderNewsPlugin;
	@Autowired
	private SysAccountService sysAccountService;
	@Test
	public void testForQueryAccount(){

		this.sysAccountService.queryById("8a83b6b14641fc5c014641fcc4a20000");
	}
	/**
	 * 对爬虫新闻插件进行处理测试
	 */
	@Test
	public void testSpiderNewsPluginProcess(){
		TextInMessage msg = new TextInMessage();
		
		msg.setContent("汽车");
		msg.setCreateTime(System.currentTimeMillis());
		msg.setFromUserName("from");
		msg.setMsgId(10000);
		msg.setMsgType(WechatMessageUtils.REQ_MESSAGE_TYPE_TEXT);
		msg.setToUserName("tony");
		
		WechatProcessResult rep = this.wechatSpiderNewsPlugin.process(msg, new WechatChannelDto());
		out(rep);
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

package com.changhong.bd.spider.test.wechat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.changhong.bd.social.domain.WechatChannelDto;
import com.changhong.bd.social.domain.WechatProcessResult;
import com.changhong.bd.social.wechat.message.in.ClickEventMessage;
import com.changhong.bd.spider.wechat.WechatBindPlugin;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月26日
 * @version 1.0
 * @description : 
 */
public class TestForWechatBindPlugin
	extends AbstractTestRunner{
	
	@Autowired
	private WechatBindPlugin wechatBindPlugin;

	@Test
	public void testForPrcess(){
		String key = this.wechatBindPlugin.getEventKey();
		out(key);
		Integer priority = this.wechatBindPlugin.getPriority();
		out(priority);
		ClickEventMessage msg = new ClickEventMessage();
		msg.setCreateTime(System.currentTimeMillis());
		msg.setEvent("CLICK");
		msg.setEventKey("bind_account");
		msg.setFromUserName("tony");
		msg.setMsgType("1");
		msg.setToUserName("service");
		
		WechatChannelDto channel = new WechatChannelDto();
		channel.setWechatChannelId("");
		WechatProcessResult res = this.wechatBindPlugin.process(msg, channel );
		out(res);
	}
}

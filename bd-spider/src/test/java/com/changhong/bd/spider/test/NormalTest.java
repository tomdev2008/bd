package com.changhong.bd.spider.test;

import java.util.Date;

import org.junit.Test;

import com.changhong.bd.social.utils.WechatMessageUtils;
import com.changhong.bd.social.utils.WechatXmlUtils;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
public class NormalTest {

	@Test
	public void testParseToXml(){
		TextOutMessage textMessage = new TextOutMessage();
		textMessage.setToUserName("");
		textMessage.setFromUserName("");
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(WechatMessageUtils.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		textMessage.setContent("中文");
		
		String rel = WechatXmlUtils.textMessageToXml(textMessage);
		System.out.println(rel);
	}
}

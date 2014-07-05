package com.changhong.bd.mail.test;

import javax.mail.MessagingException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.changhong.bd.email.service.api.MailService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月7日
 * @version 1.0
 * @description : 
 */
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml",
	"classpath*:/applicationContext-db.xml",
	"classpath*:/applicationContext-mail.xml"
})
public class ContextTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private MailService mailService;
	/**
	 * 发送邮件测试
	 * @throws MessagingException
	 */
	@Test
	public void testSendMail() throws MessagingException{
		//this.mailService.send("标题", "309103737@qq.com", "您的账户**已经和微信号**进行了绑定");
	}
	
}

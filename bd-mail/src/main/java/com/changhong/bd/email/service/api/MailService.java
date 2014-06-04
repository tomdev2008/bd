package com.changhong.bd.email.service.api;

import javax.mail.MessagingException;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月13日
 * @version 1.0
 * @description : 邮件发送服务接口
 */
public interface MailService {

	/**
	 * 发送邮件
	 * @param subject 标题
	 * @param to 收件人
	 * @param content 内容
	 * @throws MessagingException 
	 */
	public void send(
			String subject,
			String to,
			String content) throws MessagingException;
}

package com.changhong.bd.email.service.impl;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.changhong.bd.email.service.api.MailService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月13日
 * @version 1.0
 * @description : 
 */
@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	@Qualifier("javaMailSender")
	private JavaMailSender javaMailSender;
	
	@Override
	public void send(
			String subject,
			String to,
			String content) throws MessagingException{
		MimeMessage mm = this.javaMailSender.createMimeMessage();
		mm.setSubject(subject);
		
		RecipientType type = RecipientType.TO;
		Address address = new InternetAddress(to);
		mm.setRecipient(type, address);
		
		Address from = new InternetAddress("yao.qi@changhong.com");
		mm.setFrom(from);
		
		mm.setText(content);

		this.javaMailSender.send(mm);
	}
	 
}

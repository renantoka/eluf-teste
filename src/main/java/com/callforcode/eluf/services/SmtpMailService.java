package com.callforcode.eluf.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Service;
@Service
public class SmtpMailService extends AbstractMailService{

	@Autowired
	private MailSender mailSender;
	
	//@Autowired
	//private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpMailService.class);
	
	@Override
	public void sendMail(SimpleMailMessage msg) {
		LOG.info("Sending mail...");
		mailSender.send(msg);
		LOG.info("Mail sent");
		
	}
}

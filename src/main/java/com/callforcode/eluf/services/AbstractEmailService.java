package com.callforcode.eluf.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

public abstract class AbstractEmailService implements MailService {

	@Value("${default.sender}")
	private String sender;

	/*@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private JavaMailSender javaMailSender;*/

	@Override
	public void sendOrderConfirmationEmail(Order obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromOrder(Order obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getClient().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Order confirmed! Code: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;

	}

	public void sendNewPasswordEmail(Client client, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(client, newPass);
		sendEmail(sm);
	}

	private SimpleMailMessage prepareNewPasswordEmail(Client client, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(client.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Request for a new password");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("new password: " + newPass);
		return sm;
	}



}
package com.callforcode.eluf.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractMailService implements MailService {

	@Value("${default.sender}")
	private String sender;

	/*@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private JavaMailSender javaMailSender;*/

	@Override
	public void sendOrderConfirmationMail(Order obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(obj);
		sendMail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromOrder(Order obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getClient().getMail());
		sm.setFrom(sender);
		sm.setSubject("Order confirmed! Code: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;

	}

	public void sendNewPasswordMail(Client client, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordMail(client, newPass);
		sendMail(sm);
	}

	private SimpleMailMessage prepareNewPasswordMail(Client client, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(client.getMail());
		sm.setFrom(sender);
		sm.setSubject("Request for a new password");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("new password: " + newPass);
		return sm;
	}



}

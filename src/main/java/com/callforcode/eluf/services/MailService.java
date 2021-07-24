package com.callforcode.eluf.services;

import org.springframework.mail.SimpleMailMessage;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

public interface MailService {

	void sendOrderConfirmationEmail(Order obj);

	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Client client, String newPass);

	
}
package com.callforcode.eluf.services;

import org.springframework.mail.SimpleMailMessage;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

public interface MailService {

	void sendOrderConfirmationMail(Order obj);

	void sendMail(SimpleMailMessage msg);
	
	void sendNewPasswordMail(Client client, String newPass);

	
}
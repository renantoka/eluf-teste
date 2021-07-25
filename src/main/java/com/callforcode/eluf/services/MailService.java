package com.callforcode.eluf.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

@Service
public interface MailService {

	void sendOrderConfirmationMail(Order obj);

	void sendMail(SimpleMailMessage msg);
	
	void sendNewPasswordMail(Client client, String newPass);

	
}

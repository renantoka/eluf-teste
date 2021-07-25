package com.callforcode.eluf.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


public class MockMailService extends AbstractMailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockMailService.class);
	
	@Override
	public void sendMail(SimpleMailMessage msg) {
	LOG.info("Simulating ELUF mail sending...");
	LOG.info(msg.toString());
	LOG.info("ELUF Mail Sent");
		
	}




}

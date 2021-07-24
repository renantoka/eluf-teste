package com.callforcode.eluf.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.callforcode.eluf.services.DBService;
import com.callforcode.eluf.services.MailService;
import com.callforcode.eluf.services.MockMailService;



@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public MailService mailService() {
		return new MockMailService();
	}

	
}
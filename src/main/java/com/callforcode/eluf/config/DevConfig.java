package com.callforcode.eluf.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.callforcode.eluf.services.DBService;
import com.callforcode.eluf.services.MailService;
import com.callforcode.eluf.services.SmtpEmailService;



@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String Strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(Strategy)) {
			return false;
		}
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public MailService emailService() {
		return new SmtpEmailService();
	}

}

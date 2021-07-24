package com.callforcode.eluf.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class MailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Please, fill in the required fields")
	@Email(message = "The e-mail is invalid")
	private String mail;

	public MailDTO() {
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}

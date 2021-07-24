package com.callforcode.eluf.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.services.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Please, fill in the required fields")
	@Length(min = 5, max = 120, message = "Size must be between 5 and 120 characters")
	private String name;
	
	@NotEmpty(message = "Please, fill in the required fields")
	@Email(message = "The e-mail is invalid")
	private String mail;

	public ClientDTO() {

	}

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		mail = obj.getMail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



}

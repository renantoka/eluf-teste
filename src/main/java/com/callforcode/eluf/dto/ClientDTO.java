package com.callforcode.eluf.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.service.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Please, fill in the required fields")
	@Length(min = 5, max = 120, message = "Size must be between 5 and 120 characters")
	private String name;
	
	@NotEmpty(message = "Please, fill in the required fields")
	@Email(message = "The e-mail is invalid")
	private String email;

	public ClientDTO() {

	}

	public ClientDTO(Client obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}

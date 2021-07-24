package com.callforcode.eluf.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Please, fill in the required fields")
	@Length(min = 5, max = 120, message = "Size must be between 5 and 120 characters")
	private String name;

	@NotEmpty(message = "Please, fill in the required fields")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Please, fill in the required fields")
	private String cpfOrCnpj;
	private Integer type;
	
	@NotEmpty(message = "Please, fill in the required fields")
	private String password;

	@NotEmpty(message = "Please, fill in the required fields")
	private String street;

	@NotEmpty(message = "Please, fill in the required fields")
	private String number;

	private String complement;
	private String neighborhood;

	@NotEmpty(message = "O preenchimento é obrigatório")
	private String zipCode;

	private String phone1;
	private String phone2;
	private String phone3;

	private Integer cityId;

	public ClientNewDTO() {

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

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}

package com.callforcode.eluf.model;

import java.util.Date;

import javax.persistence.Entity;

import com.callforcode.eluf.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;


@Entity
@JsonTypeName("PaymentByBankSlip")
public class PaymentByBankSlip extends Payment {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date expirationDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date payday;

	public PaymentByBankSlip() {
		
	}

	public PaymentByBankSlip(Integer id, PaymentStatus status, Order order, Date expirationDate,
			Date payday) {
		super(id, status, order);
		this.expirationDate = expirationDate;
		this.payday = payday;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate (Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}

}

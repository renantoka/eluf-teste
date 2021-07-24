package com.callforcode.eluf.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.callforcode.eluf.model.PaymentByBankSlip;

@Service
public class BankSlipService {

	public void fulfillBankSlipPayment(PaymentByBankSlip pay, Date OrderNowSet) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(OrderNowSet);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pay.setExpirationDate(cal.getTime());
	}
}
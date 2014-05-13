package com.cmcdelhi.quasar.action;

import java.util.List;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.service.QuasarService;
import com.opensymphony.xwork2.ActionSupport;

public class PendingPaymentAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("Inside Pending Payment Action Class");
		return SUCCESS;
	}

	public List<Payment> obtainePendingPayments() {
		QuasarService qs = new QuasarService();
		return qs.getPendingPayments();
	}

}

package com.cmcdelhi.quasar.payMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cmcdelhi.quasar.paymentDetails.Payment;

@Entity
public class PaymentMode {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentModeID;

	@OneToOne
	private Payment payment;

	public long getPaymentModeID() {
		return paymentModeID;
	}

	public void setPaymentModeID(long paymentModeID) {
		this.paymentModeID = paymentModeID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}

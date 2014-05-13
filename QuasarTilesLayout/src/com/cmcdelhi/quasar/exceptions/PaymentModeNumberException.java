package com.cmcdelhi.quasar.exceptions;

//thrown when invalid Payment ID,TransactionID,DDNumber,ChequNumber
public class PaymentModeNumberException extends Exception {

	public PaymentModeNumberException(String message) {
		super("Invalid payment input. " + message);

	}
}

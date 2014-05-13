package com.cmcdelhi.quasar.exceptions;

//thrown when Issue Date or Expiry Date is Invalid
public class DateException extends Exception {
	public DateException(String message) {
		super("Date is invalid. " + message);
	}

}

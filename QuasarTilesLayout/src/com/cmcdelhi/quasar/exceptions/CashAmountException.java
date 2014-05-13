package com.cmcdelhi.quasar.exceptions;

public class CashAmountException extends Exception {

	public CashAmountException(String message) {
		super("Cash Amount is  invalid. " + message);
	}
}

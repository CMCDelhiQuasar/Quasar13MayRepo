package com.cmcdelhi.quasar.exceptions;

public class CashDetailException extends Exception {

	public CashDetailException(String message) {
		super("Cash Detail is invalid. " + message);
	}
}

package com.cmcdelhi.quasar.exceptions;

public class InvalidNumberException extends Exception {
	public InvalidNumberException(String message) {
		super("Number is invalid. " + message);
	}
}

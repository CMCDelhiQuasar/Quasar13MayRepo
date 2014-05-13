package com.cmcdelhi.quasar.exceptions;

public class NameException extends Exception {

	public NameException(String message) {
		super("Invalid Name.Please check for invalid charachters in name. "
				+ message);
	}
}

package com.cmcdelhi.quasar.exceptions;

public class QuasarConnectionException extends Exception {
	public QuasarConnectionException(String message) {
		super("Hey Dude ,i m unable to obtain the connection. " + message);
	}
}

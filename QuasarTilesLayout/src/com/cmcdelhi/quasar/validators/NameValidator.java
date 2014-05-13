package com.cmcdelhi.quasar.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {
	private Pattern pattern;
	private Matcher matcher;

	// private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	private static final String NAME_PATTERN = "^[A-Za-z ]{3,100}$";

	public NameValidator() {
		pattern = Pattern.compile(NAME_PATTERN);
	}

	/**
	 * Validate name with regular expression
	 * 
	 * @param name
	 *            name for validation
	 * @return true valid name, false invalid name
	 */
	public boolean validate(String name) {

		matcher = pattern.matcher(name);
		return matcher.matches();

	}
}

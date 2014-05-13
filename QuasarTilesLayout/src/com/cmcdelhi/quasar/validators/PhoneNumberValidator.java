package com.cmcdelhi.quasar.validators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
	private Pattern pattern;
	private Matcher matcher;

	// private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	private static final String NUMBER_PATTERN = "^[0-9]{9,12}$";

	public PhoneNumberValidator() {
		pattern = Pattern.compile(NUMBER_PATTERN);
	}

	public boolean validate(final String num) {

		matcher = pattern.matcher(num);
		return matcher.matches();

	}
}

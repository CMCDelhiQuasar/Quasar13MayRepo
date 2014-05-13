package com.cmcdelhi.quasar.paymentDetails;

public enum InstallmentType {
	FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHT(
			8), NINTH(9), TENTH(10);

	int value;

	private InstallmentType(int value) {
		this.value = value;
	}

}

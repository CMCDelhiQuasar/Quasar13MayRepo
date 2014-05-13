package com.cmcdelhi.quasar.payMode;

public enum Note {

	THOUSAND(1000), FIVEHUNDRED(500), HUNDRED(100), FIFTY(50), TWENTY(20), TEN(
			10), FIVE(5), TWO(2), ONE(1);

	int noteValue;

	private Note(int noteValue) {
		this.noteValue = noteValue;
	}

	public int getNoteValue() {
		return noteValue;
	}

	public static int getFIVEHUNDRED() {
		return 500;
	}

	public static int getTHOUSAND() {
		return 1000;
	}

	public static int getHUNDRED() {
		return 100;
	}

	public static int getFIFTY() {
		return 50;
	}

	public static int getTWENTY() {
		return 20;
	}

	public static int getTEN() {
		return 10;
	}

	public static int getFIVE() {
		return 5;
	}

	public static int getTWO() {
		return 2;
	}

	public static int getONE() {
		return 1;
	}
}

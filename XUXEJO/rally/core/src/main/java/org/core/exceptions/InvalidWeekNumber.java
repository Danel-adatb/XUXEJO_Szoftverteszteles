package org.core.exceptions;

public class InvalidWeekNumber extends Exception {

	public InvalidWeekNumber(int week) {
		super(String.valueOf(week));
	}

}

package org.core.exceptions;

import java.time.LocalDate;

public class InvalidDate extends Exception {

	public InvalidDate(LocalDate date) {
		super(date.toString());
	}

}

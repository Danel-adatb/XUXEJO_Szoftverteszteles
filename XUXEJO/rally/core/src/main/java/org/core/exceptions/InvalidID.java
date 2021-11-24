package org.core.exceptions;

import java.time.LocalDate;

public class InvalidID extends Exception {

	public InvalidID(long id) {
		super(String.valueOf(id));
	}

}

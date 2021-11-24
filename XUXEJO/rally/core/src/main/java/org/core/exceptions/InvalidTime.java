package org.core.exceptions;

public class InvalidTime extends Exception {

	public InvalidTime(double time) {
		super(String.valueOf(time));
	}

}

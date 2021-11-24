package org.core;

public interface AccidentMessage {
	public default void OK() {
		System.out.println("Crew OK!");
	};
}


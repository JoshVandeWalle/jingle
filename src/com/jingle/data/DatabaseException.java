package com.jingle.data;

/**
 * @author Henry Harvey
 * The DatabaseException creates a custom exception for database errors
 */

// unchecked exception for handling database errors
public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Takes in an error
	 * Uses the super Runtime Exception to throw the error
	 * 
	 * @param e - exception from the super class
	 */
	public DatabaseException(Throwable e) {
		super(e);
	}

}

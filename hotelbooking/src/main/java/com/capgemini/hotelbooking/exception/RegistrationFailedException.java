package com.capgemini.hotelbooking.exception;
/**
 * This is a custom exception created by the programmer 
 *
 */
public class RegistrationFailedException extends RuntimeException {

	/**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = 2547737836130835889L;
	String message = "Registration Failed ";
	 /**
	 * this method return message when ever exception called
	 * 
	 * @return message
	 */
	public String requriedMessage() {
		return message;
		
	}

}

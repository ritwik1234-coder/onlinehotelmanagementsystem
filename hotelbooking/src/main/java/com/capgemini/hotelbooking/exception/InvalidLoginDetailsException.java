package com.capgemini.hotelbooking.exception;
/**
 * This is a custom exception created by the programmer
 *
 */
public class InvalidLoginDetailsException extends RuntimeException {

	/**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = -591429637482102529L;
	String message = "Invalid login detail";
	 /**
	 * this method return message when ever exception called
	 * 
	 * @return message
	 */
	public String requriedMessage() {
		return message;

	}

}

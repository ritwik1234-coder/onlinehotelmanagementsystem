package com.capgemini.hotelbooking.exception;
/**
 * This is a custom exception created by the programmer 
 * 
 *
 */
public class BookingNotDoneException extends RuntimeException {

	 /**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = -2865346708972078134L;
	String message = "Booking not done ";
	 /**
		 * this method return message when ever exception called
		 * 
		 * @return message
		 */
	public String requriedMessage() {
		return message;
		
	}

}

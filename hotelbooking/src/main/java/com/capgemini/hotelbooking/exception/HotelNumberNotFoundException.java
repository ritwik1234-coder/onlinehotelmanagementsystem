package com.capgemini.hotelbooking.exception;
/**
 * This is a custom exception created by the programmer 
 *
 */
public class HotelNumberNotFoundException extends RuntimeException {

	/**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = 409570842289884275L;
	String message = "Given Hotelnumber not found, give proper hotelnumber ";
	 /**
	 * this method return message when ever exception called
	 * 
	 * @return message
	 */
	public String requriedMessage() {
		return message;
		
	}

}

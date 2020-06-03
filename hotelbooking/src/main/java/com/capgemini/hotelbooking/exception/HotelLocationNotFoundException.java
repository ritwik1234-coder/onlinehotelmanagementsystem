package com.capgemini.hotelbooking.exception;
/**
 * This is a custom exception created by the programmer   
 *
 */
public class HotelLocationNotFoundException extends RuntimeException {

	/**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = -4875491883423708022L;
	String message = "Hotel not found in the given location";
	 /**
	 * this method return message when ever exception called
	 * 
	 * @return message
	 */
	public String requriedMessage() {
		return message;
		
	}

}

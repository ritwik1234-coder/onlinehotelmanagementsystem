package com.capgemini.hotelbooking.exception;

/**
 * This is a custom exception created by the programmer  
 *
 */

public class RoomNotFoundException extends RuntimeException {

	/**
	 * this method will give serialVersionUID
	 */
	private static final long serialVersionUID = 1555194088857033720L;
	String message = "Room not found";

	/**
	 * this method return message when ever exception called
	 * 
	 * @return message
	 */

	public String requriedMessage() {
		return message;

	}

}

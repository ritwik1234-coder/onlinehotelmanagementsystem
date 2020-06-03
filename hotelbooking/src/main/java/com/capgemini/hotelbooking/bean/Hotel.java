package com.capgemini.hotelbooking.bean;

import java.io.Serializable;

/**
 * 
 * This is a bean class which contains Hotel Details having Private Variables
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 *
 */
public class Hotel implements Serializable {
	private static final long serialVersionUID = -4189310670065959891L;

	public Hotel() {

	}

	private String hotelNumber;

	private String hotelName;

	private String location;

	private String emailId;

	private long phoneNumber;

	/**
	 * This Method Is Used Get HoteNumber
	 * 
	 * @return hotelnumber
	 */

	public String getHotelNumber() {
		return hotelNumber;
	}

	/**
	 * This Method Is Used Set HoteNumber
	 * 
	 * @param hotelNumber
	 */

	public void setHotelNumber(String HotelNumber) {
		hotelNumber = HotelNumber;
	}

	/**
	 * This Method Is Used Get HoteName
	 * 
	 * @return hotelname
	 */

	public String getHotelName() {
		return hotelName;
	}

	/**
	 * This Method Is Used Set HoteName
	 * 
	 * @param hotelName
	 */

	public void setHotelName(String HotelName) {
		hotelName = HotelName;
	}

	/**
	 * This Method Is Used Get Location
	 * 
	 * @return location
	 */

	public String getLocation() {
		return location;
	}

	/**
	 * This Method Is Used Set Location
	 * 
	 * @param Location
	 */

	public void setLocation(String Location) {
		location = Location;
	}

	/**
	 * This Method Is Used Get EmailId
	 * 
	 * @return emailId
	 */

	public String getEmailid() {
		return emailId;
	}

	/**
	 * This Method Is Used Set EmailId
	 * 
	 * @param emailId
	 */

	public void setEmailid(String emailid) {
		emailId = emailid;
	}

	/**
	 * This Method Is Used Get PhoneNumber
	 * 
	 * @return phoneNumber
	 */

	public long getPhonenumber() {
		return phoneNumber;
	}

	/**
	 * This Method Is Used Get Phonenumber
	 * 
	 * @param phoneNumber
	 */

	public void setPhonenumber(long Phonenumber) {
		phoneNumber = Phonenumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((hotelNumber == null) ? 0 : hotelNumber.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (hotelName == null) {
			if (other.hotelName != null)
				return false;
		} else if (!hotelName.equals(other.hotelName))
			return false;
		if (hotelNumber == null) {
			if (other.hotelNumber != null)
				return false;
		} else if (!hotelNumber.equals(other.hotelNumber))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "hotelnumber=" + hotelNumber + "\n hotelname=" + hotelName + "\n location=" + location
				+ "\n emailid=" + emailId + "\n phonenumber=" + phoneNumber + "\n";
	}

}

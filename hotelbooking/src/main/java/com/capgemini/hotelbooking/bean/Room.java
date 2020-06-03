package com.capgemini.hotelbooking.bean;

import java.io.Serializable;

/**
 * 
 * This is a bean class which contains Room Details having Private Variables
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 *
 */
public class Room implements Serializable {
	private static final long serialVersionUID = 4487394938619411950L;

	public Room() {

	}

	private String hotelNumber;

	private String roomType;

	private String hotelName;

	private String hotelLocation;

	private double price;

	/**
	 * This method is to get hotel number
	 * 
	 * @return hotel number
	 */
	public String getHotelNumber() {
		return hotelNumber;
	}

	/**
	 * this method is used to set hotel number
	 * 
	 * @param hotelNumber
	 */

	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

	/**
	 * this method is used to get roomtype
	 * 
	 * @return roomtype
	 */

	public String getRoomType() {
		return roomType;
	}

	/**
	 * this method is used to set roomtype
	 * 
	 * @param roomType
	 */

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * this method is used to get hotel name
	 * 
	 * @return hotel name
	 */

	public String getHotelName() {
		return hotelName;
	}

	/**
	 * this is used to set hotel name
	 * 
	 * @param hotelName
	 */

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * this method is used to get Hotellocation
	 * 
	 * @return hotelLocation
	 */

	public String getHotelLocation() {
		return hotelLocation;
	}

	/**
	 * this method set Hotellocation
	 * 
	 * @param hotelLocation
	 */

	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}

	/**
	 * this method is used to get price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * this method is used to set price
	 * 
	 * @param price
	 */

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelLocation == null) ? 0 : hotelLocation.hashCode());
		result = prime * result + ((hotelName == null) ? 0 : hotelName.hashCode());
		result = prime * result + ((hotelNumber == null) ? 0 : hotelNumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
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
		Room other = (Room) obj;
		if (hotelLocation == null) {
			if (other.hotelLocation != null)
				return false;
		} else if (!hotelLocation.equals(other.hotelLocation))
			return false;
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
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "hotelnumber=" + hotelNumber + "\n roomtype=" + roomType + "\n hotelname=" + hotelName
				+ "\n hotellocation=" + hotelLocation + "\n price=" + price + "\n";
	}

}

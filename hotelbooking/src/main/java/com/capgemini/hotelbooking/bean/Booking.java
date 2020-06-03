package com.capgemini.hotelbooking.bean;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * This is a bean class which contains Booking Details having Private Variables
 * 
 * We Used Getter And Setter Methods TO Get And Set The Variables
 *
 */
public class Booking implements Serializable {

	private static final long serialVersionUID = -7674532254027568485L;

	public Booking() {

	}

	private String bookedUserName;

	private String bookedName;

	private Long bookedNumber;

	private LocalDate bookedDate;

	private LocalDate checkinDate;

	private LocalDate checkoutDate;

	private String bookedHotel;

	private String bookedRoomType;

	private double bookedPrice;

	private String paymentMode;

	/**
	 * 
	 * This Method Is Used To Get Booked userName
	 * 
	 * @return bookedUserName
	 */
	public String getBookedUserName() {
		return bookedUserName;
	}

	/**
	 * 
	 * This Method Is Used To set Booked userName
	 * 
	 * @param bookedUserName
	 */
	public void setBookedUserName(String bookusername) {
		this.bookedUserName = bookusername;
	}

	/**
	 * 
	 * This Method Is Used To Get Booked Name
	 * 
	 * @return bookedName
	 */
	public String getBookedName() {
		return bookedName;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Name
	 * 
	 * @param bookedName
	 */
	public void setBookedName(String bookname) {
		this.bookedName = bookname;
	}

	/**
	 * 
	 * This Method Is Used To Get Booked Number
	 * 
	 * @return bookedNumber
	 */
	public Long getBookedNumber() {
		return bookedNumber;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Name
	 * 
	 * @param bookedNumber
	 */
	public void setBookedNumber(Long booknumber) {
		this.bookedNumber = booknumber;
	}

	/**
	 * 
	 * This Method Is Used To Get Booked Hotel
	 * 
	 * @return bookedHotel
	 */
	public String getBookedHotel() {
		return bookedHotel;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Hotel
	 * 
	 * @param bookedHotel
	 */
	public void setBookedHotel(String bookhotel) {
		this.bookedHotel = bookhotel;
	}

	/**
	 * This Method Is Used To Get Booked Roomtype
	 * 
	 * @return bookedRoomType
	 */
	public String getBookedRoomType() {
		return bookedRoomType;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Roomtype
	 * 
	 * @param bookedRoomType
	 */
	public void setBookedRoomType(String bookroomtype) {
		this.bookedRoomType = bookroomtype;
	}

	/**
	 * This Method Is Used To Get Booked Price
	 * 
	 * @return bookedPrice
	 */
	public double getBookedPrice() {
		return bookedPrice;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Price
	 * 
	 * @param bookedPrice
	 */
	public void setBookedPrice(double bookprice) {
		this.bookedPrice = bookprice;
	}

	/**
	 * This Method Is Used To Get Booked Date
	 * 
	 * @return bookedDate
	 */
	public LocalDate getBookedDate() {
		return bookedDate;
	}

	/**
	 * 
	 * This Method Is Used To set Booked Date
	 * 
	 * @param bookedDate
	 */
	public void setBookedDate(LocalDate bookdate) {
		this.bookedDate = bookdate;
	}

	/**
	 * This Method Is Used To Get Check-in- Date
	 * 
	 * @return checkinDate
	 */
	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	/**
	 * 
	 * This Method Is Used To set Check-in- Date
	 * 
	 * @param checkinDate
	 */
	public void setCheckinDate(LocalDate checkindate) {
		this.checkinDate = checkindate;
	}

	/**
	 * This Method Is Used To Get Checkout- Date
	 * 
	 * @return checkoutDate
	 */
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	/**
	 * 
	 * This Method Is Used To set Checkout- Date
	 * 
	 * @param checkoutDate
	 */
	public void setCheckoutDate(LocalDate checkoutdate) {
		this.checkoutDate = checkoutdate;
	}

	/**
	 * This Method Is Used To Get PaymentMode
	 * 
	 * @return paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * 
	 * This Method Is Used To set PaymentMode
	 * 
	 * @param paymentMode
	 */
	public void setPaymentMode(String paymentmode) {
		this.paymentMode = paymentmode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookedUserName == null) {
			if (other.bookedUserName != null)
				return false;
		} else if (!bookedUserName.equals(other.bookedUserName))
			return false;
		if (bookedDate == null) {
			if (other.bookedDate != null)
				return false;
		} else if (!bookedDate.equals(other.bookedDate))
			return false;
		if (bookedHotel == null) {
			if (other.bookedHotel != null)
				return false;
		} else if (!bookedHotel.equals(other.bookedHotel))
			return false;
		if (bookedName == null) {
			if (other.bookedName != null)
				return false;
		} else if (!bookedName.equals(other.bookedName))
			return false;
		if (bookedNumber == null) {
			if (other.bookedNumber != null)
				return false;
		} else if (!bookedNumber.equals(other.bookedNumber))
			return false;
		if (bookedPrice != other.bookedPrice)
			return false;
		if (bookedRoomType == null) {
			if (other.bookedRoomType != null)
				return false;
		} else if (!bookedRoomType.equals(other.bookedRoomType))
			return false;
		if (checkinDate == null) {
			if (other.checkinDate != null)
				return false;
		} else if (!checkinDate.equals(other.checkinDate))
			return false;
		if (checkoutDate == null) {
			if (other.checkoutDate != null)
				return false;
		} else if (!checkoutDate.equals(other.checkoutDate))
			return false;
		if (paymentMode == null) {
			if (other.paymentMode != null)
				return false;
		} else if (!paymentMode.equals(other.paymentMode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "bookedusername=" + bookedUserName + "\n bookedname=" + bookedName + "\n bookednumber="
				+ bookedNumber + "\n bookedhotel=" + bookedHotel + "\n bookedroomtype=" + bookedRoomType
				+ "\n bookedprice=" + bookedPrice + "\n bookeddate=" + bookedDate + "\n checkindate=" + checkinDate
				+ "\n checkoutdate=" + checkoutDate + "\n paymentmode=" + paymentMode + "\n";
	}

}

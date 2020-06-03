package com.capgemini.hotelbooking.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.factory.Factory;
/**
 * This class contains the booking details of customer 
 * 
 * @author Ritwik
 *
 */
public class BookingRepository {
	public List<Booking> getBookingInformationList() {
    List<Booking> booking = new ArrayList<Booking>();


		Booking booking1 = Factory.getBookingInstance();
		booking1.setBookedName("ritwik r");
		booking1.setBookedUserName("ritwik");
		booking1.setBookedHotel("Catorist");
		booking1.setBookedNumber(9039285096l);
		booking1.setBookedRoomType("Single sitter");

		booking1.setBookedPrice(15000);
		booking1.setBookedDate(LocalDate.of(2020, 05, 06));
		booking1.setCheckinDate(LocalDate.of(2020, 05, 10));
		booking1.setCheckoutDate(LocalDate.of(2020, 05, 11));

		Booking booking2 = Factory.getBookingInstance();
		booking2.setBookedName("yadav y");
		booking2.setBookedUserName("yadav");
		booking2.setBookedHotel("Catorist");
		booking2.setBookedNumber(9039285097l);
		booking2.setBookedRoomType("Double sitter");

		booking2.setBookedPrice(18000);
		booking2.setBookedDate(LocalDate.of(2020, 05, 10));
		booking2.setCheckinDate(LocalDate.of(2020, 05, 10));
		booking2.setCheckoutDate(LocalDate.of(2020, 05, 19));

		Booking booking3 = Factory.getBookingInstance();
		booking3.setBookedName("ritwik y");
		booking3.setBookedUserName("ritwik567");
		booking3.setBookedHotel("Black Mamba");
		booking3.setBookedNumber(9039285098l);
		booking3.setBookedRoomType("Double sitter");

		booking3.setBookedPrice(18000);
		booking3.setBookedDate(LocalDate.of(2020, 05, 06));
		booking3.setCheckinDate(LocalDate.of(2020, 05, 28));
		booking3.setCheckoutDate(LocalDate.of(2020, 05, 29));


		booking.add(booking1);
		booking.add(booking2);
		booking.add(booking3);

		return booking;

	}

}




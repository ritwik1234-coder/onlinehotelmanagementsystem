package com.capgemini.hotelbooking.factory;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
import com.capgemini.hotelbooking.dao.HotelDAO;
import com.capgemini.hotelbooking.dao.HotelDAOImpl;
import com.capgemini.hotelbooking.service.HotelService;
import com.capgemini.hotelbooking.service.HotelServiceImpl;
import com.capgemini.hotelbooking.validation.InputValidation;
import com.capgemini.hotelbooking.validation.InputValidationImpl;
/**
 * This is the class where the object of every class and interface is created
 *
 * By using class name we can use the object where ever we want
 */
public class Factory {


	public static InputValidation getInputValidationInstance() {
		return new InputValidationImpl();
	}

	public static HotelService getHotelServiceInstance() {

		HotelService hotelservice = new HotelServiceImpl();
		return hotelservice;

	}

	public static Customer getCustomerInstance() {
		Customer customerinformation = new Customer();
		return customerinformation;
	}

	public static HotelDAO getHotelDAOInstance() {
		HotelDAO dao = new HotelDAOImpl();
		return dao;
	}

	public static Hotel getHotelInstance() {
		Hotel hotelinformation = new Hotel();
		return hotelinformation;
	}

	public static Booking getBookingInstance() {
		Booking bookinginformation = new Booking();
		return bookinginformation;
	}

	public static Room getRoomInstance() {
		Room roominformation = new Room();
		return roominformation;
	}
	
	public static Employee getEmployeeInstance() {
		Employee employeeinfo = new Employee();
		return employeeinfo;
	}

}

package com.capgemini.hotelbooking.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
/**
 * This is an Interface of HotelService 
 * 
 */
public interface HotelService {
	public boolean choiceVerify(String choice);

	public boolean loginDetail(String userName, String password);

	public boolean userName(String userName);

	public boolean nameVerify(String name);

	public boolean phoneNumber(String phonenumber);

	public boolean emailId(String mail);

	public boolean password(String password);

	public boolean addCustomerInfo(String username, String name, String mail, long phonenumber, String password);

	public boolean createPassword(String userName);

	public boolean updatePassword(String userName, String password);

	public List<Hotel> getHotelInfo(String location);

	public List<Booking> checkBookingInfo(String username);

	public List<Room> checkRooms(String location, String hotelNumber);

	public List<Room> bookingRoom(String roomTpye, String hotelNumber, String location);

	public boolean verifyDate(String date);

	public boolean bookingDetail(Booking bookinginfo);

	public boolean employeeLoginDetail(String userName, String password);

	public List<Customer> getAllCustomers();

	public boolean checkUserNameForRegistration(String username);

	public boolean adminLoginDetail(String userName, String password) throws FileNotFoundException, IOException;

	public boolean checkLocationInfo(String location);

	public boolean checkHotelNumber(String hotelNumber, String location);

	public boolean verifyHotelNumber(String hotelNumber);

	public boolean addHotelInfo(String hotelName, String location, String hotelNumber, String mail, long phoneNumber);

	public boolean deleteHotelInfo(String hotelNumber, String location);

	public boolean updateHotelInfo(String hotelNumber, String location);

	public boolean updateForHotelInfo(String hotelNumber, String location, String hotelName, String mail, long phoneNumber);

	public List<Hotel> getAllHotels();

	public List<Hotel> checkRoomInfo(String location, String hotelNumber);

	public boolean priceVerify(String price);

	public boolean addRoomInfo(String location, String hotelName, String hotelNumber, String roomType,
			double price);

	public boolean deleteRoomInfo(String location, String hotelNumber, String roomType);

	public boolean updateRoomInfo(String location, String hotelNumber, String roomType, double price);

	public List<Room> getAllRooms();

	public boolean checkUserNameForEmployee(String userName);

	public boolean salaryVerify(String salary);

	public boolean addEmployeeInfo(String userName, String name, String mail, long phonenumber, String password,
			int salary);

	public List<Employee> getAllEmployees();

	public boolean employeeDeleteInfo(String userName);

	public boolean checkEmployeeUpdateInfo(String userName);

	public boolean updateEmployeeInfo(String username, String name, String mail, long phonenumber, String password,
			int salary);

	public List<Booking> getPatronList(String hotelname);

	public List<Booking> getDateRequried(LocalDate date);

}



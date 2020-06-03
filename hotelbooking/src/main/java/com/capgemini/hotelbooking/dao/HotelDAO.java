package com.capgemini.hotelbooking.dao;

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
 * This is an Interface of HotelDAO 
 *
 */
public interface HotelDAO {

	public boolean login(String userName, String password);

	public boolean addCustomerDetail(String username, String name, String mail, long phonenumber, String password);

	public boolean changePassword(String userName);

	public boolean updatePassword(String userName, String password);

	public List<Hotel> getHotelLocationInfo(String location);

	public List<Booking> checkCustomerBookingInfo(String username);

	public List<Room> getRoomForBookingInfo(String location, String hotelNumber);

	public List<Room> checkRoomForBookingInfo(String roomTpye, String hotelNumber, String location);

	public boolean addBookingInfo(Booking bookinginfo);

	public boolean employeeLoginDetail(String userName, String password);

	public List<Customer> getCustomerInfo();

	public boolean adminLoginDetail(String userName, String password) throws FileNotFoundException, IOException;

	public boolean checkUniqueUserNameForCustomer(String username);

	public boolean checkHotelLocation(String location);

	public boolean checkUniqueHotelNumber(String hotelNumber, String location);

	public boolean addHotelDetail(String hotelName, String location, String hotelNumber, String mail,
			long phoneNumber);

	public boolean deleteHotelDetail(String hotelNumber, String location);

	public boolean updateHotelDetail(String hotelNumber, String location);

	public boolean updateForHotelDetail(String hotelNumber, String location, String hotelName, String mail,
			long phoneNumber);

	public List<Hotel> getAllHotel();

	public List<Hotel> checkRoomDetail(String location, String hotelNumber);

	public boolean addRoomInfo(String location, String hotelName, String hotelNumber, String roomType,
			double price);

	public boolean deleteRoomInfo(String location, String hotelNumber, String roomType);

	public boolean updateRoomInfo(String location, String hotelNumber, String roomType, double price);

	public List<Room> getAllRooms();

	public boolean checkUniqueUserNameForEmployee(String userName);

	public boolean addEmployeeDetail(String userName, String name, String mail, long phonenumber, String password,
			int salary);

	public List<Employee> getAllEmployees();

	public boolean employeeDeleteInfo(String userName);

	public boolean checkEmployeeUpdateInfo(String userName);

	public boolean updateEmployeeInfo(String username, String name, String mail, long phonenumber, String password,
			int salary);

	public List<Booking> getPatronList(String hotelname);

	public List<Booking> getDateRequried(LocalDate date);

}

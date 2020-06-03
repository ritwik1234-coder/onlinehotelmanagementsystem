package com.capgemini.hotelbooking.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.hotelbooking.validation.InputValidation;
import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
import com.capgemini.hotelbooking.dao.HotelDAO;
import com.capgemini.hotelbooking.factory.Factory;
/**
*
* This class contains Implementation of HotelService Interface and its abstract method
* 
*/
public class HotelServiceImpl implements HotelService {
	InputValidation inputvalidation = Factory.getInputValidationInstance();

	HotelDAO dao = Factory.getHotelDAOInstance();

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */

	public boolean choiceVerify(String choice) {
		while (!inputvalidation.choiceValidate1(choice)) {
			return false;

		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */

	public boolean loginDetail(String userName, String password) {
		return dao.login(userName, password);

	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean userName(String userName) {

		while (!inputvalidation.usernameValidation(userName)) {

			return false;

		}

		return true;
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */

	public boolean nameVerify(String name) {

		while (!inputvalidation.nameValidation(name)) {
			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */

	public boolean phoneNumber(String phonenumber) {
		while (!inputvalidation.phonenumberValidation(phonenumber)) {
			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean emailId(String mail) {
		while (!inputvalidation.emailValidation(mail)) {
			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean password(String password) {
		while (!inputvalidation.passwordValidation(password)) {
			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean addCustomerInfo(String username, String name, String mail, long phonenumber, String password) {
		return dao.addCustomerDetail(username, name, mail, phonenumber, password);

	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean createPassword(String userName) {
		return dao.changePassword(userName);

	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean updatePassword(String userName, String password) {

		return dao.updatePassword(userName, password);

	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Hotel> getHotelInfo(String location) {

		return dao.getHotelLocationInfo(location);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Booking> checkBookingInfo(String username) {

		return dao.checkCustomerBookingInfo(username);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Room> checkRooms(String location, String hotelNumber) {

		return dao.getRoomForBookingInfo(location, hotelNumber);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Room> bookingRoom(String roomTpye, String hotelNumber, String location) {

		return dao.checkRoomForBookingInfo(roomTpye, hotelNumber, location);
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean verifyDate(String date) {
		while (!inputvalidation.dateValidation(date)) {

			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean bookingDetail(Booking bookinginfo) {

		return dao.addBookingInfo(bookinginfo);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean employeeLoginDetail(String userName, String password) {

		return dao.employeeLoginDetail(userName, password);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Customer> getAllCustomers() {

		return dao.getCustomerInfo();
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean checkUserNameForRegistration(String username) {

		return dao.checkUniqueUserNameForCustomer(username);

	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean adminLoginDetail(String userName, String password) throws FileNotFoundException, IOException {

		return dao.adminLoginDetail(userName, password);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */

	public boolean checkLocationInfo(String location) {

		return dao.checkHotelLocation(location);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean checkHotelNumber(String hotelNumber, String location) {

		return dao.checkUniqueHotelNumber(hotelNumber, location);
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean verifyHotelNumber(String hotelNumber) {
		while (!inputvalidation.hotelNumbervalidation(hotelNumber)) {

			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean addHotelInfo(String hotelName, String location, String hotelNumber, String mail, long phoneNumber) {

		return dao.addHotelDetail(hotelName, location, hotelNumber, mail, phoneNumber);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean deleteHotelInfo(String hotelNumber, String location) {

		return dao.deleteHotelDetail(hotelNumber, location);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean updateHotelInfo(String hotelNumber, String location) {

		return dao.updateHotelDetail(hotelNumber, location);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean updateForHotelInfo(String hotelNumber, String location, String hotelName, String mail,
			long phoneNumber) {

		return dao.updateForHotelDetail(hotelNumber, location, hotelName, mail, phoneNumber);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Hotel> getAllHotels() {

		return dao.getAllHotel();
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Hotel> checkRoomInfo(String location, String hotelNumber) {

		return dao.checkRoomDetail(location, hotelNumber);
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */
	public boolean priceVerify(String price) {
		while (!inputvalidation.priceValidation(price)) {

			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean addRoomInfo(String location, String hotelName, String hotelNumber, String roomType,
			double price) {

		return dao.addRoomInfo(location, hotelName, hotelNumber, roomType, price);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean deleteRoomInfo(String location, String hotelNumber, String roomType) {

		return dao.deleteRoomInfo(location, hotelNumber, roomType);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean updateRoomInfo(String location, String hotelNumber, String roomType, double price) {

		return dao.updateRoomInfo(location, hotelNumber, roomType, price);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Room> getAllRooms() {

		return dao.getAllRooms();
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean checkUserNameForEmployee(String userName) {

		return dao.checkUniqueUserNameForEmployee(userName);
	}

	/**
	 * This method acts like a bridge between controller and validation
	 * 
	 * @return true
	 */

	public boolean salaryVerify(String salary) {
		while (!inputvalidation.salaryValidation(salary)) {

			return false;
		}
		return true;
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */

	public boolean addEmployeeInfo(String userName, String name, String mail, long phonenumber, String password,
			int salary) {

		return dao.addEmployeeDetail(userName, name, mail, phonenumber, password, salary);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Employee> getAllEmployees() {

		return dao.getAllEmployees();
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */

	public boolean employeeDeleteInfo(String userName) {

		return dao.employeeDeleteInfo(userName);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean checkEmployeeUpdateInfo(String userName) {

		return dao.checkEmployeeUpdateInfo(userName);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return true
	 */
	public boolean updateEmployeeInfo(String username, String name, String mail, long phonenumber, String password,
			int salary) {

		return dao.updateEmployeeInfo(username, name, mail, phonenumber, password, salary);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Booking> getPatronList(String hotelname) {

		return dao.getPatronList(hotelname);
	}

	/**
	 * This method acts like a bridge between controller and dao
	 * 
	 * @return list
	 */
	public List<Booking> getDateRequried(LocalDate date) {

		return dao.getDateRequried(date);
	}


}


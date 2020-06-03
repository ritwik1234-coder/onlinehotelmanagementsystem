package com.capgemini.hotelbooking.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.repository.BookingRepository;
import com.capgemini.hotelbooking.repository.CustomerRepository;
import com.capgemini.hotelbooking.repository.EmployeeRepository;
import com.capgemini.hotelbooking.repository.HotelRepository;
import com.capgemini.hotelbooking.repository.RoomRepository;

/**
 * This is an implementation class of HotelDAO interface and its methods
 * 
 * @author Ritwik
 *
 */
public class HotelDAOImpl implements HotelDAO {
	static List<Customer> customersDetail = new CustomerRepository().getCustomerInformationList();
	static List<Hotel> hotelListDetail = new HotelRepository().getHotelInformationList();
	static List<Booking> bookingDetail = new BookingRepository().getBookingInformationList();
	static List<Room> roomDetail = new RoomRepository().getRoomInformationList();
	static List<Employee> employeeListDetail = new EmployeeRepository().getEmployeeInformationList();

	Properties properties = new Properties();

	/**
	 * This method is used to check whether th details given by the customer valid
	 * or not
	 * 
	 * @return true when details matched
	 * 
	 * @return false when details not matched
	 * 
	 * @param username, password
	 * 
	 */

	public boolean login(String userName, String password) {
		int check = 0;
		for (Customer customerinformation : customersDetail) {
			if (customerinformation.getUserName().equals(userName)
					&& customerinformation.getPassword().equals(password)) {
				check++;
			}
		}

		return check == 0 ? false : true;
	}

	/**
	 * This method is used to add details of customer
	 * 
	 * @param username,name,mail,phonenumber,password
	 * 
	 * @return true when details added
	 * 
	 * @return false when details not added
	 */

	public boolean addCustomerDetail(String username, String name, String mail, long phonenumber, String password) {
		Customer customerinfo = Factory.getCustomerInstance();

		customerinfo.setUserName(username);
		customerinfo.setName(name);
		customerinfo.setEmailId(mail);
		customerinfo.setPhoneNumber(phonenumber);
		customerinfo.setPassword(password);
		customersDetail.add(customerinfo);
		if (customersDetail.isEmpty()) {
			return false;
		} else {

			return true;
		}
	}

	/**
	 * this method is used to check the username when the customer forgets his
	 * password
	 * 
	 * @param username
	 * 
	 * @return true username found
	 * 
	 * @return false username not found
	 */

	public boolean changePassword(String userName) {
		int check = 0;
		for (Customer customerinformation : customersDetail) {
			if (customerinformation.getUserName().equals(userName)) {
				check++;
			}

		}
		return check == 0 ? false : true;
	}

	/**
	 * This method is used to update password when customer matches to his username
	 * 
	 * @param username,password
	 * 
	 * @return true when password updated
	 * 
	 * @return false when password not updated
	 */

	public boolean updatePassword(String userName, String newPassword) {

		int check = 0;
		for (Customer customerinformation : customersDetail) {
			if (customerinformation.getUserName().equals(userName)) {

				check++;
				customerinformation.setPassword(newPassword);
			}

		}
		return check == 0 ? false : true;

	}

	/**
	 * This method is used to get the hotel present in the location
	 * 
	 * @return list
	 * 
	 * @param location
	 */

	public List<Hotel> getHotelLocationInfo(String location) {
		int count = 0;
		ArrayList<Hotel> list = new ArrayList<Hotel>();

		for (Hotel hotelInfo : hotelListDetail) {
			if (hotelInfo.getLocation().equals(location)) {
				count++;
				list.add(hotelInfo);
			}
		}

		if (count == 0) {
			return null;
		} else {
			return list;
		}
	}

	/**
	 * This method is used to get the booking done by specific user
	 * 
	 * @param username
	 * 
	 * @return list
	 */

	public List<Booking> checkCustomerBookingInfo(String username) {
		int count = 0;
		ArrayList<Booking> list = new ArrayList<Booking>();

		for (Booking bookinginfo : bookingDetail) {
			if (bookinginfo.getBookedUserName().equals(username)) {
				count++;
				list.add(bookinginfo);

			}
		}
		if (count == 0) {
			return null;
		} else {

			return list;
		}

	}

	/**
	 * This method is used to return the list of hotel present
	 * 
	 * @param location,hotelnumber
	 * 
	 * @return list
	 */

	public List<Room> getRoomForBookingInfo(String location, String hotelNumber) {

		int count = 0;
		ArrayList<Room> list = new ArrayList<Room>();

		for (Room roominfo : roomDetail) {
			if (roominfo.getHotelNumber().equals(hotelNumber) && roominfo.getHotelLocation().equals(location)) {
				count++;

				list.add(roominfo);

			}
		}
		if (count == 0) {

			return null;
		} else {
			return list;
		}
	}

	/**
	 * This method is used to return the list of hotel present
	 * 
	 * @param roomtype,hotelnumber,location
	 * 
	 * @return list
	 */

	public List<Room> checkRoomForBookingInfo(String roomTpye, String hotelNumber, String location) {
		int count = 0;
		ArrayList<Room> list = new ArrayList<Room>();
		for (Room roominformationbean : roomDetail) {
			if (roominformationbean.getRoomType().equals(roomTpye)
					&& roominformationbean.getHotelNumber().equals(hotelNumber)
					&& roominformationbean.getHotelLocation().equals(location)) {
				count++;
				list.add(roominformationbean);
			}
		}
		if (count == 0) {
			return null;
		} else {

			return list;
		}

	}

	/**
	 * This method is used to add booking details
	 */
	public boolean addBookingInfo(Booking bookinginfo) {
		bookingDetail.add(bookinginfo);
		if (bookingDetail.isEmpty()) {

			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method is used to check details of employee
	 * 
	 * @param username,password
	 * 
	 * @return true when details matched
	 * 
	 * @return false when details not matched
	 */

	public boolean employeeLoginDetail(String userName, String password) {
		int check = 0;
		for (Employee employeeinfo : employeeListDetail) {
			if (employeeinfo.getUserName().equals(userName) && employeeinfo.getPassword().equals(password)) {
				check++;
			}
		}
		return check == 0 ? false : true;
	}

	/**
	 * This method will get the list of customes present
	 * 
	 * @return list
	 * 
	 * @return null
	 */

	public List<Customer> getCustomerInfo() {

		if (customersDetail.isEmpty()) {
			return null;
		} else {
			return customersDetail;

		}

	}

	/**
	 * This method will check the details of admin matched or not
	 * 
	 * @return true when details matched
	 * 
	 * @return false when details not matched
	 */

	public boolean adminLoginDetail(String userName, String password1) throws IOException {
		int count = 0;
		FileInputStream fileinput = new FileInputStream("db.properties");
		properties.load(fileinput);

		if (properties.getProperty("username").equals(userName)
				&& properties.getProperty("password").equals(password1)) {
			count++;

		}
		return count == 0 ? false : true;
	}

	/**
	 * this method will check the username of customer already present or not
	 * 
	 * @param user name
	 * @return true if username matches
	 * 
	 * @return false if username doesnot matches
	 */

	public boolean checkUniqueUserNameForCustomer(String username) {
		int count = 0;
		for (Customer customerinfo : customersDetail) {
			if (customerinfo.getUserName().equals(username)) {
				count++;
			}
		}
		return count == 0 ? false : true;

	}

	/**
	 * This method will check location to add hotel in the respective location
	 * 
	 * @param location
	 * 
	 * @return true if location matched
	 * 
	 * @return false if location not matched
	 */

	public boolean checkHotelLocation(String location) {

		int count = 0;
		for (Hotel hotelinfo : hotelListDetail) {
			if (hotelinfo.getLocation().equals(location)) {
				count++;
			}
		}
		return count == 0 ? false : true;
	}

	/**
	 * This method is used to check whether hotel number is already present or not
	 * 
	 * @param hotelnumber,location
	 * 
	 * @return true if matched
	 * 
	 * @return false if not matched
	 */

	public boolean checkUniqueHotelNumber(String hotelNumber, String location) {
		int count = 0;
		for (Hotel hotelinfo : hotelListDetail) {
			if (hotelinfo.getLocation().equals(location) && hotelinfo.getHotelNumber().equals(hotelNumber)) {
				count++;
			}
		}

		return count == 0 ? false : true;
	}

	/**
	 * This method, adds the hotel details into the list of hotel data
	 * 
	 * @return true if data added sucessfully
	 * 
	 * @return false if data not added sucessfully
	 */

	public boolean addHotelDetail(String hotelName, String location, String hotelNumber, String mail,
			long phoneNumber) {
		Hotel hotelinfo = Factory.getHotelInstance();
		hotelinfo.setHotelName(hotelName);
		hotelinfo.setLocation(location);
		hotelinfo.setHotelNumber(hotelNumber);
		hotelinfo.setEmailid(mail);
		hotelinfo.setPhonenumber(phoneNumber);

		hotelListDetail.add(hotelinfo);
		if (hotelListDetail.isEmpty()) {

			return false;
		} else {
			return true;
		}
	}

	/**
	 * This method, delete the hotel from the hotel list
	 * 
	 * @return true if the hotel deleted
	 * 
	 * @return false if the hotel is not deleted
	 */

	public boolean deleteHotelDetail(String hotelNumber, String location) {
		int count = 0;

		Iterator<Hotel> hotelbean = hotelListDetail.iterator();
		while (hotelbean.hasNext()) {

			Hotel str = hotelbean.next();
			if (str.getHotelNumber().equals(hotelNumber) && str.getLocation().equals(location)) {
				count++;

				hotelbean.remove();

			}

		}
		return count == 0 ? false : true;

	}

	/**
	 * this method, update the details of the hotel in the hotel list
	 * 
	 * @return true if data updated
	 * 
	 * @return false if data is not updated
	 */

	public boolean updateHotelDetail(String hotelNumber, String location) {
		int count = 0;
		for (Hotel hotelinfo : hotelListDetail) {
			if (hotelinfo.getLocation().equals(location) && hotelinfo.getHotelNumber().equals(hotelNumber)) {
				count++;
			}
		}
		return count == 0 ? false : true;

	}

	public boolean updateForHotelDetail(String hotelNumber, String location, String hotelName, String mail,
			long phoneNumber) {

		for (Hotel hotelinfo : hotelListDetail) {
			if (hotelinfo.getLocation().equals(location) && hotelinfo.getHotelNumber().equals(hotelNumber)) {

				hotelinfo.setHotelName(hotelName);
				hotelinfo.setEmailid(mail);
				hotelinfo.setPhonenumber(phoneNumber);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method provides the hotels present in the hotellist
	 * 
	 * @return list
	 */

	public List<Hotel> getAllHotel() {
		if (hotelListDetail.isEmpty()) {
			return null;
		} else {

			return hotelListDetail;
		}

	}

	/**
	 * This method will check the hotel details to add room to it
	 * 
	 * @param location,hotelNumber
	 * 
	 * @return list if details present
	 * 
	 * @return null if details not present
	 */

	public List<Hotel> checkRoomDetail(String location, String hotelNumber) {
		int count = 0;
		ArrayList<Hotel> list = new ArrayList<Hotel>();
		for (Hotel hotelinfo : hotelListDetail) {
			if (hotelinfo.getHotelNumber().equals(hotelNumber) && hotelinfo.getLocation().equals(location)) {
				count++;
				list.add(hotelinfo);
			}

		}
		if (count == 0) {

			return null;
		} else {
			return list;
		}
	}

	/**
	 * this method will add the details of the room to the room lis of a specific
	 * hotel
	 * 
	 * @return list
	 */

	public boolean addRoomInfo(String location, String hotelName, String hotelNumber, String roomType, double price) {
		Room roominfo = Factory.getRoomInstance();
		roominfo.setHotelLocation(location);
		roominfo.setHotelName(hotelName);
		roominfo.setHotelNumber(hotelNumber);
		roominfo.setRoomType(roomType);
		roominfo.setPrice(price);
		roomDetail.add(roominfo);
		if (roomDetail.isEmpty()) {

			return false;
		} else {
			return true;
		}
	}

	/**
	 * this method will delete the details of the room in the room list
	 * 
	 * @param location,hotelnumber,roomtype
	 * 
	 * @return true if data deleted
	 * 
	 * @return false if data is not deleted
	 */

	public boolean deleteRoomInfo(String location, String hotelNumber, String roomType) {

		int count = 0;
		Iterator<Room> roombean = roomDetail.iterator();
		while (roombean.hasNext()) {

			Room str = roombean.next();
			if (str.getHotelLocation().equals(location) && str.getHotelNumber().equals(hotelNumber)
					&& str.getRoomType().equals(roomType)) {
				count++;
				roombean.remove();

			}

		}
		return count == 0 ? false : true;

	}

	/**
	 * this method will update the details of the room in the room list
	 * 
	 * @param location,hotelnumber,roomtype,price
	 * 
	 * @return true if data updated
	 * 
	 * @return false if data not updated
	 */

	public boolean updateRoomInfo(String location, String hotelNumber, String roomType, double price) {
		int count = 0;
		for (Room roominfo : roomDetail) {
			if (roominfo.getHotelLocation().equals(location) && roominfo.getHotelNumber().equals(hotelNumber)) {
				count++;
				roominfo.setRoomType(roomType);
				roominfo.setPrice(price);
			}
		}

		return count == 0 ? false : true;
	}

	/**
	 * This method will return the list of rooms
	 * 
	 * @return list
	 */

	public List<Room> getAllRooms() {

		if (roomDetail.isEmpty()) {
			return null;
		} else {

			return roomDetail;
		}

	}

	/**
	 * this method will check the username of employee whether it is already present
	 * or not
	 * 
	 * @param user name
	 * @return true if username matches
	 * 
	 * @return false if username not matches
	 */

	public boolean checkUniqueUserNameForEmployee(String userName) {
		int count = 0;
		for (Employee customerinfo : employeeListDetail) {
			if (customerinfo.getUserName().equals(userName)) {
				count++;
			}
		}
		return count == 0 ? false : true;
	}

	/**
	 * This method will add the employee details into the list of employee data
	 * 
	 * @return true if data added sucessfully
	 * 
	 * @return false if data not added sucessfully
	 */

	public boolean addEmployeeDetail(String userName, String name, String mail, long phonenumber, String password,
			int salary) {
		Employee employeeinfo = Factory.getEmployeeInstance();
		employeeinfo.setUserName(userName);
		employeeinfo.setName(name);
		employeeinfo.setEmailid(mail);
		employeeinfo.setPhonenumber(phonenumber);
		employeeinfo.setPassword(password);
		employeeinfo.setSalary(salary);
		employeeListDetail.add(employeeinfo);
		if (employeeListDetail.isEmpty()) {
			return false;
		} else {

			return true;
		}
	}

	public List<Employee> getAllEmployees() {

		return employeeListDetail;
	}

	/**
	 * This method will delete the employee details from the list of employee data
	 * 
	 * @return true if data added
	 * 
	 * @return false if data not added
	 */
	public boolean employeeDeleteInfo(String userName) {
		int count = 0;
		Iterator<Employee> employeeBean = employeeListDetail.iterator();
		while (employeeBean.hasNext()) {

			Employee str = employeeBean.next();
			if (str.getUserName().equals(userName)) {
				count++;

				employeeBean.remove();

			}
		}
		return count == 0 ? false : true;
	}

	public boolean checkEmployeeUpdateInfo(String userName) {
		int count = 0;
		for (Employee employeeinfo : employeeListDetail) {
			if (employeeinfo.getUserName().equals(userName)) {
				count++;
			}
		}
		return count == 0 ? false : true;
	}

	/**
	 * 
	 * This method will update the hotel details into the list of employee data
	 * 
	 * @return true if data added
	 * 
	 * @return false if data not added
	 *
	 */

	public boolean updateEmployeeInfo(String username, String name, String mail, long phonenumber, String password,
			int salary) {
		for (Employee employeeinfo : employeeListDetail) {
			if (employeeinfo.getUserName().equals(username)) {
				employeeinfo.setName(name);
				employeeinfo.setEmailid(mail);
				employeeinfo.setPhonenumber(phonenumber);
				employeeinfo.setPassword(password);
				employeeinfo.setSalary(salary);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will provide the guest list of specific hotel from booking list
	 * 
	 * @param hotelname
	 * 
	 * @return list if details present
	 * 
	 * @return false if details nit present
	 */

	public List<Booking> getPatronList(String hotelname) {
		int count = 0;
		ArrayList<Booking> list = new ArrayList<Booking>();
		for (Booking bookinginfo : bookingDetail) {
			if (bookinginfo.getBookedHotel().equals(hotelname)) {
				count++;
				list.add(bookinginfo);

			}
		}
		if (count == 0) {

			return null;
		} else {
			return list;
		}

	}

	/**
	 * This method will provide the guest list of specific date from booking list
	 * 
	 * @param LocalDate date
	 * 
	 * @return list if details present
	 * 
	 * @return false if details nit present
	 */

	public List<Booking> getDateRequried(LocalDate date) {

		int count = 0;
		ArrayList<Booking> list = new ArrayList<Booking>();
		for (Booking bookinginfo : bookingDetail) {
			if (bookinginfo.getCheckinDate().equals(date)) {
				count++;
				list.add(bookinginfo);

			}
		}
		if (count == 0) {

			return null;
		} else {
			return list;
		}
	}

}

package com.capgemini.hotelbooking.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbooking.factory.Factory;

class HotelDAOImplTest {

	static HotelDAO dao = Factory.getHotelDAOInstance();

	@Test
	@BeforeAll
	@DisplayName("Valid Employee login")
	static void testEmployeeLoginDetails() {
		assertEquals(true, dao.employeeLoginDetail("amit", "Amit@567"));
	}

	@Test
	@DisplayName("customer login valid")
	void testLogin() {

		assertEquals(true, dao.login("ritwik", "Ritwik@567"));

	}

	@Test
	@DisplayName("Invalidcustomer login")

	void testLogin1() {

		assertEquals(false, dao.login("ritwik", "rit@567"));

	}

	@Test
	@DisplayName("createpassword")
	void testCreatePassword() {
		assertEquals(true, dao.changePassword("ritwik"));
	}

	@Test
	@DisplayName("Invalid createpassword")
	void testCreatePassword1() {
		assertEquals(false, dao.changePassword("Rit@56"));
	}

	@Test
	@DisplayName("valid update password")
	void testUpdatePassword() {
		assertEquals(true, dao.updatePassword("ritwik", "Ritwik@567 "));
	}

	@Test
	@DisplayName("Invalid  update password")
	void testUpdatePassword1() {
		assertEquals(false, dao.updatePassword("Ritw@567", "Ami@567"));
	}

	@Test
	@DisplayName("Hotel location")
	void testGetHotelLocation() {
		assertNotNull(dao.getHotelLocationInfo("pondicherry"));
	}

	@Test
	@DisplayName("Invalid Hotel location")
	void testGetHotelLocation1() {
		assertEquals(null, dao.getHotelLocationInfo("mumbai"));
	}

	@Test
	@DisplayName("valid customer booking")
	void testCheckCustomerBooking() {
		assertNotNull(dao.checkCustomerBookingInfo("ritwik"));
	}

	@Test
	@DisplayName("Invalid valid customer booking")
	void testCheckCustomerBooking1() {
		assertEquals(null, dao.checkCustomerBookingInfo("ritw"));
	}

	@Test
	@DisplayName("room for booking")
	void testGetRoomForBooking() {
		assertNotNull(dao.getRoomForBookingInfo("pondicherry", "2"));
	}

	@Test
	@DisplayName("Invalid room for booking")
	void testGetRoomForBooking1() {
		assertEquals(null, dao.getRoomForBookingInfo("pondicherry", "3"));
	}

	@Test
	@DisplayName("Invalid check room for booking")
	void testCheckRoomForBooking1() {
		assertEquals(null, dao.checkRoomForBookingInfo("Triple", "3", "mumbai"));
	}

	@Test
	@DisplayName("Invalid  Employee login")
	void testEmployeeLoginDetails1() {
		assertEquals(false, dao.employeeLoginDetail("Amit", "amit@567"));
	}

	@Test
	@DisplayName("get customers")
	void testGetCustomers() {
		assertNotNull(dao.getCustomerInfo());
	}

	@Test
	@DisplayName("valid admin login")
	void testAdminLoginDetails() throws FileNotFoundException, IOException {
		assertEquals(true, dao.adminLoginDetail("admin", "Admin@123"));
	}

	@Test
	@DisplayName("Invalid  admin login")
	void testAdminLoginDetails1() throws FileNotFoundException, IOException {
		assertEquals(false, dao.adminLoginDetail("admin", "dmin@123"));
	}

	@Test
	@DisplayName("invalid unique username")
	void testCheckUniqueUsernameForCustomer() {
		assertEquals(false, dao.checkUniqueUserNameForCustomer("amit"));
	}

	@Test
	@DisplayName("valid unique username")
	void testCheckUniqueUsernameForCustomer1() {
		assertEquals(false, dao.checkUniqueUserNameForCustomer("ami"));
	}

	@Test
	@DisplayName("check location")
	void testCheckLocationForHotel() {
		assertEquals(true, dao.checkHotelLocation("chennai"));

	}

	@Test
	@DisplayName("Invalid check location")
	void testCheckLocationForHotel1() {
		assertEquals(false, dao.checkHotelLocation("munnar"));

	}

	@Test
	@DisplayName("invalid hotel unique number")
	void testCheckUniqueHotelNumber() {
		assertEquals(true, dao.checkUniqueHotelNumber("1", "pondicherry"));
	}

	@Test
	@DisplayName("valid hotel unique number")
	void testCheckUniqueHotelNumber1() {
		assertEquals(false, dao.checkUniqueHotelNumber("3", "pondicherry"));
	}

	@Test
	@DisplayName("valid delete hotel")
	void testDeleteHotelDetails() {
		assertEquals(true, dao.deleteHotelDetail("2", "chennai"));
	}

	@Test
	@DisplayName("Invalid delete hotel")
	void testDeleteHotelDetails1() {
		assertEquals(false, dao.deleteHotelDetail("3", "chennai"));
	}

	@Test
	@DisplayName("valid update")
	void testUpdateHotelDetails() {
		assertEquals(true, dao.updateHotelDetail("1", "chennai"));
	}

	@Test
	@DisplayName("Invalid update")
	void testUpdateHotelDetails1() {
		assertEquals(false, dao.updateHotelDetail("3", "chennai"));
	}

	@Test
	@DisplayName("Update hotel")
	void testUpdateForHotelDetails() {
		assertEquals(true, dao.updateForHotelDetail("2", "pondicherry", "Krishna", "krishna@gmail.com", 9999999990l));
	}

	@Test
	@DisplayName("Invalid Update hotel")
	void testUpdateForHotelDetails1() {
		assertEquals(false, dao.updateForHotelDetail("3", "mumbai", "Krishna", "krishna@gmail.com", 9999999990l));
	}

	@Test
	@DisplayName("get all hotels")
	void testGetAllHotel() {
		assertNotNull(dao.getAllHotel());

	}

	@Test
	@DisplayName("check hotel details")
	void testCheckRoomDetails() {
		assertNotNull(dao.checkRoomDetail("pondicherry", "1"));
	}

	@Test
	@DisplayName("Invalid check hotel details")
	void testCheckRoomDetails1() {
		assertEquals(null, dao.checkRoomDetail("pondicherry", "3"));
	}

	@Test
	@DisplayName("valid delete room")
	void testDeleteRoom() {
		assertEquals(true, dao.deleteRoomInfo("chennai", "1", "Single sitter"));
	}

	@Test
	@DisplayName("Invalid  delete room")
	void testDeleteRoom1() {
		assertEquals(false, dao.deleteRoomInfo("chennai", "5", "Single"));
	}

	@Test
	@DisplayName("update room")
	void testUpdateRoom() {
		assertEquals(true, dao.updateRoomInfo("pondicherry", "1", "Single", 10000));
	}

	@Test
	@DisplayName("Invalid update room")
	void testUpdateRoom1() {
		assertEquals(false, dao.updateRoomInfo("pondicherry", "11", "Single", 10000));
	}

	@Test
	@DisplayName("get all rooms")
	void testGetAllRooms() {
		assertNotNull(dao.getAllRooms());
	}

	@Test
	@DisplayName("Invalid unique username for employee")
	void testCheckUniqueUsernameForEmployee() {
		assertEquals(false, dao.checkUniqueUserNameForEmployee("ami"));
	}

	@Test
	@DisplayName("valid unique username for employee")
	void testCheckUniqueUsernameForEmployee1() {
		assertEquals(true, dao.checkUniqueUserNameForEmployee("amit"));
	}

	@Test
	@DisplayName("get all employees")
	void testGetAllEmployees() {
		assertNotNull(dao.getAllEmployees());
	}

	@Test
	@DisplayName("Invalid  employee delete")
	void testEmployeeDelete() {
		assertEquals(false, dao.employeeDeleteInfo("ami"));
	}

	@Test
	@DisplayName("check employee to update")
	void testCheckEmployeeUpdate() {
		assertEquals(true, dao.checkEmployeeUpdateInfo("amit"));
	}

	@Test
	@DisplayName("invalid check employee to update")
	void testCheckEmployeeUpdate1() {
		assertEquals(false, dao.checkEmployeeUpdateInfo("ami"));
	}

	@Test
	@DisplayName("update employee")
	void testUpdateEmployee() {
		assertEquals(true,
				dao.updateEmployeeInfo("amit", "Amit Yadav", "amit@gmail.com", 9039285136l, "Chandra@123", 56000));
	}

	@Test
	@DisplayName("guest list")
	void testGetGuestList() {
		assertNotNull(dao.getPatronList("Catorist"));
	}

	@Test
	@DisplayName("Invalidguest list")
	void testGetGuestList1() {
		assertEquals(null, dao.getPatronList("hotel raja"));
	}

	@Test
	@DisplayName("Date requried")
	void testGetDateRequried() {
		assertEquals(null, dao.getDateRequried(LocalDate.of(2020, 05, 22)));
	}

	@Test
	@DisplayName("Add Customer")
	void testAddDetails() {
		assertEquals(true, dao.addCustomerDetail("pankaj567", "pankaj yadav", "pankaj@gmail.com", 9000000009l, "Pankaj@123"));
	}

	@Test
	@DisplayName("Add Hotel")
	void testAddHotelDetails() {

		assertEquals(true, dao.addHotelDetail("Krishna", "chennai", "5", "krishna@gmail.com", 9999999990l));

	}

	@Test
	@DisplayName("Add Room")
	void testAddRoomInformation() {

		assertEquals(true, dao.addRoomInfo("chennai", "Catorist", "2", "Double", 20000));
	}

	@Test
	@DisplayName("Add Employee")
	void testAddEmployee() {
		assertEquals(true,
				dao.addEmployeeDetail("mihul", "mihul singh", "mihul@gmail.com", 7000093488l, "Mihul@123", 21000));
	}

}

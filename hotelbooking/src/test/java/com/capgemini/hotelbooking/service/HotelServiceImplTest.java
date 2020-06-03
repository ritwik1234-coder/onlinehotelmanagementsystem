package com.capgemini.hotelbooking.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.dao.HotelDAO;
import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.validation.InputValidation;

class HotelServiceImplTest {

	Customer customerinfo = Factory.getCustomerInstance();
	InputValidation inputvalidation = Factory.getInputValidationInstance();
	static HotelDAO dao = Factory.getHotelDAOInstance();

	@Test
	@DisplayName("Employee login")
	static void testEmployeeLoginDetails() {
		assertEquals(true, dao.employeeLoginDetail("amit", "Amit@567"));
	}

	@Test
	@DisplayName("Valid Choice")
	void testChoiceVerify() {
		assertEquals(true, inputvalidation.choiceValidate1("1"));
	}

	@Test
	@DisplayName("InValid Choice")
	void testChoiceVerify1() {
		assertEquals(false, inputvalidation.choiceValidate1("11"));
	}

	@Test
	@DisplayName("Customer Login")
	void testLoginDetails() {
		assertEquals(true, dao.login("ritwik", "Ritwik@567"));

	}

	@Test
	@DisplayName("Invalid Customer Login")
	void testLoginDetails1() {
		assertEquals(false, dao.login("ritwik567", "Ritwik@567"));

	}

	@Test
	@DisplayName("Valid username")
	void testUserName() {
		assertEquals(true, inputvalidation.usernameValidation("ritwik"));
	}

	@Test
	@DisplayName("InValid username")
	void testUserName1() {
		assertEquals(false, inputvalidation.usernameValidation("90"));
	}

	@Test
	@DisplayName("Valid name")
	void testNameVerify() {
		assertEquals(true, inputvalidation.nameValidation("Ritwik Yadav"));
	}

	@Test
	@DisplayName("InValid name")
	void testNameVerify1() {
		assertEquals(false, inputvalidation.nameValidation("ritwik yadav ya"));
	}

	@Test
	@DisplayName("Valid Phone number")
	void testPhoneNumber() {
		assertEquals(true, inputvalidation.phonenumberValidation("9039285097"));
	}

	@Test
	@DisplayName("InValid Phone number")
	void testPhoneNumber1() {
		assertEquals(false, inputvalidation.phonenumberValidation("1493115665"));
	}

	@Test
	@DisplayName("Valid mailid")
	void testMailId() {
		assertEquals(true, inputvalidation.emailValidation("ritwik@gmail.com"));
	}

	@Test
	@DisplayName("InValid mailid")
	void testMailId1() {
		assertEquals(false, inputvalidation.emailValidation("ritwikgmail.com"));
	}

	@Test
	@DisplayName("valid password")
	void testPassword() {
		assertEquals(true, inputvalidation.passwordValidation("Ritwik@567"));
	}

	@Test
	@DisplayName("InValid password")
	void testPassword1() {
		assertEquals(false, inputvalidation.passwordValidation("ritwik@123"));
	}

	@Test
	@DisplayName("check username for creating password")
	void testCreatePassword() {
		assertEquals(true, dao.changePassword("ritwik"));
	}

	@Test
	@DisplayName("check invalid username for creating password")
	void testCreatePassword1() {
		assertEquals(false, dao.changePassword("rritwik"));
	}

	@Test
	@DisplayName("Update password")
	void testUpdatePassword() {
		assertEquals(true, dao.updatePassword("ritwik", "Ritwik@567"));
	}

	@Test
	@DisplayName("Get Hotel on requried location")
	void testGetHotel() {
		assertEquals(null, dao.getHotelLocationInfo("bhimavaram"));
	}

	@Test
	@DisplayName("Get Hotel on requried location")
	void testGetHotel1() {
		assertNotNull(dao.getHotelLocationInfo("chennai"));
	}

	@Test
	@DisplayName("Invalid customer")
	void testCheckBooking() {
		assertEquals(null, dao.checkCustomerBookingInfo("rit"));
	}

	@Test
	@DisplayName("valid customer")
	void testCheckBooking1() {
		assertNotNull(dao.checkCustomerBookingInfo("ritwik"));
	}

	@Test
	@DisplayName("Check rooms")
	void testCheckRooms() {
		assertNotNull(dao.getRoomForBookingInfo("chennai", "2"));
	}

	@Test
	@DisplayName("Check rooms")
	void testCheckRooms1() {
		assertEquals(null, dao.getRoomForBookingInfo("chennai", "5"));
	}

	@Test
	@DisplayName("Valid Date")
	void testDateVerify() {
		assertEquals(true, inputvalidation.dateValidation("2020-05-20"));
	}

	@Test
	@DisplayName("InValid Date")
	void testDateVerify1() {
		assertEquals(false, inputvalidation.dateValidation("2020-5-20"));
	}

	@Test
	@DisplayName("Invalid Employee login")
	void testEmployeeLoginDetails1() {
		assertEquals(false, dao.employeeLoginDetail("ami", "Amit@123"));
	}

	@Test
	void testGetAllCustomers() {
		assertNotNull(dao.getCustomerInfo());
	}

	@Test
	@DisplayName("Unique username")
	void testCheckUserNameForRegistration() {
		assertEquals(true, dao.checkUniqueUserNameForCustomer("ritwik"));
	}

	@Test
	@DisplayName("Unique username")
	void testCheckUserNameForRegistration1() {
		assertEquals(false, dao.checkUniqueUserNameForCustomer("ritwik1"));
	}

	@Test
	@DisplayName("Valid admin")
	void testAdminLoginDetails() throws FileNotFoundException, IOException {
		assertEquals(true, dao.adminLoginDetail("admin", "Admin@123"));
	}

	@Test
	@DisplayName("Valid admin")
	void testAdminLoginDetails1() throws FileNotFoundException, IOException {
		assertEquals(false, dao.adminLoginDetail("admin", "admin@123"));
	}

	@Test
	@DisplayName("valid Location")
	void testCheckLocation() {
		assertEquals(true, dao.checkHotelLocation("pondicherry"));
	}

	@Test
	@DisplayName("Invalid Location")
	void testCheckLocation1() {
		assertEquals(false, dao.checkHotelLocation("mumbai"));
	}

	@Test
	@DisplayName("existing hotelnumber")
	void testCheckHotelNumber1() {
		assertEquals(false, dao.checkUniqueHotelNumber("pondicherry", "2"));
	}

	@Test
	@DisplayName("HotelNumber")
	void testHotelNumberVerify() {
		assertEquals(true, inputvalidation.hotelNumbervalidation("1"));
	}

	@Test
	@DisplayName("HotelNumber")
	void testHotelNumberVerify1() {
		assertEquals(false, inputvalidation.hotelNumbervalidation("100"));
	}

	@Test
	@DisplayName("Delete hotel")
	void testDeleteHotel() {
		assertEquals(true, dao.deleteHotelDetail("2", "chennai"));
	}

	@Test
	@DisplayName("Update Hotel")
	void testUpdateHotel() {
		assertEquals(true, dao.updateHotelDetail("2", "pondicherry"));
	}

	@Test
	@DisplayName("Update Hotel Details")
	void testUpdateForHotel() {
		assertEquals(true, dao.updateForHotelDetail("2", "pondicherry", "Krishna", "krishna@gmail.com", 90000000009l));
	}

	@Test
	@DisplayName("all hotels")
	void testGetAllHotels() {
		assertNotNull(dao.getAllHotel());
	}

	@Test
	void testCheckRoom() {
		assertNotNull(dao.checkRoomDetail("pondicherry", "2"));
	}

	@Test
	@DisplayName("Price Validation")
	void testPriceVerify() {
		assertEquals(true, inputvalidation.priceValidation("10000"));
	}

	@Test
	@DisplayName("Price Validation")
	void testPriceVerify1() {
		assertEquals(false, inputvalidation.priceValidation("100"));
	}

	@Test
	@DisplayName("Delete Room")
	void testDeleteRoom() {
		assertEquals(true, dao.deleteRoomInfo("pondicherry", "2", "Double sitter"));
	}

	@Test
	@DisplayName("Invalid Delete Room")
	void testDeleteRoom1() {
		assertEquals(false, dao.deleteRoomInfo("pondicherry", "2", "Triple"));
	}

	@Test
	@DisplayName("Update Room")
	void testUpdateRoom() {
		assertEquals(true, dao.updateRoomInfo("chennai", "2", "Double", 20000));
	}

	@Test
	void testGetAllRoom() {
		assertNotNull(dao.getAllRooms());
	}

	@Test
	void testCheckUserNameForEmployee() {
		assertEquals(false, dao.checkUniqueUserNameForEmployee("ami"));
	}

	@Test
	void testCheckUserNameForEmployee1() {
		assertEquals(true, dao.checkUniqueUserNameForEmployee("amit"));
	}

	@Test
	void testSalaryVerify() {
		assertEquals(true, inputvalidation.salaryValidation("15000"));
	}

	@Test
	void testSalaryVerify1() {
		assertEquals(false, inputvalidation.salaryValidation("abd"));
	}

	@Test
	void testGetAllEmployees() {
		assertNotNull(dao.getAllEmployees());
	}

	@Test
	void testEmployeeDelete() {
		assertEquals(false, dao.employeeDeleteInfo("ami"));
	}

	@Test
	void testCheckEmployeeUpdate() {
		assertEquals(true, dao.checkEmployeeUpdateInfo("amit"));
	}

	@Test
	void testUpdateEmployee() {
		assertEquals(true,
				dao.updateEmployeeInfo("amit", "Amit Yadav", "amit@gmail.com", 9039285136l, "Chandra@123", 25000));
	}

	@Test
	void testGetGuestList() {
		assertNotNull(dao.getPatronList("Catorist"));
	}

	@Test
	void testGetGuestList1() {
		assertEquals(null, dao.getPatronList("Grazial"));
	}

	@Test
	void testGetDateRequried() {
		assertNotNull(dao.getDateRequried(LocalDate.of(2020, 05, 10)));
	}

	@Test

	void testGetDateRequried1() {
		assertEquals(null, dao.getDateRequried(LocalDate.of(2020, 05, 06)));
	}

}

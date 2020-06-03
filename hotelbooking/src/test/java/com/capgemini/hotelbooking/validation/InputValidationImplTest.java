package com.capgemini.hotelbooking.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.hotelbooking.factory.Factory;

class InputValidationImplTest {

	InputValidation inputvalidation = Factory.getInputValidationInstance();

	@Test
	@DisplayName("Valid choice")
	void testChoiceValidate1() {
		assertEquals(true, inputvalidation.choiceValidate1("1"));
	}

	@Test
	@DisplayName("InValid choice")
	void testChoiceValidate() {
		assertEquals(false, inputvalidation.choiceValidate1("11"));
	}

	@Test
	@DisplayName("Valid username")
	void testUsernameValidation() {
		assertEquals(true, inputvalidation.usernameValidation("ritwik"));
	}

	@Test
	@DisplayName("InValid username")
	void testUsernameValidation1() {
		assertEquals(false, inputvalidation.usernameValidation("1"));
	}

	@Test
	@DisplayName("Name Validation")
	void testNameValidation() {
		assertEquals(true, inputvalidation.nameValidation("Ritwik Yadav"));
	}

	@Test
	@DisplayName("Invalid Name Validation")
	void testNameValidation1() {
		assertEquals(false, inputvalidation.nameValidation("ritwik"));
	}

	@Test
	@DisplayName("Phone number validation")
	void testPhonenumberValidation() {
		assertEquals(true, inputvalidation.phonenumberValidation("9039285096"));
	}

	@Test
	@DisplayName("Phone number validation")
	void testPhonenumberValidation1() {
		assertEquals(false, inputvalidation.phonenumberValidation("4493115665"));
	}

	@Test
	@DisplayName("validmail")
	void testMailValidation() {
		assertEquals(true, inputvalidation.emailValidation("vinod@gmail.com"));
	}

	@Test
	@DisplayName("Invalid mail")
	void testMailValidation1() {
		assertEquals(false, inputvalidation.emailValidation("vinod.com"));
	}

	@Test
	@DisplayName("valid password")
	void testPasswordValidation() {
		assertEquals(true, inputvalidation.passwordValidation("Ritwik@567"));
	}

	@Test
	@DisplayName("Invalid password")
	void testPasswordValidation1() {
		assertEquals(false, inputvalidation.passwordValidation("ritwik@123"));
	}

	@Test
	@DisplayName("Valid date")
	void testDateValidation() {
		assertEquals(true, inputvalidation.dateValidation("2020-05-06"));
	}

	@Test
	@DisplayName("InValid date")
	void testDateValidation1() {
		assertEquals(false, inputvalidation.dateValidation("6-5-2020"));
	}

	@Test
	@DisplayName("Valid hotelnumber")
	void testHotelNumbervalidation() {
		assertEquals(true, inputvalidation.hotelNumbervalidation("1"));
	}

	@Test
	@DisplayName("Invalid hotelnumber")
	void testHotelNumbervalidation2() {
		assertEquals(false, inputvalidation.hotelNumbervalidation("d1"));
	}

	@Test
	@DisplayName("valid price")
	void testPriceValidation() {
		assertEquals(true, inputvalidation.priceValidation("10000"));
	}

	@Test
	@DisplayName("Invalid price")
	void testPriceValidation1() {
		assertEquals(false, inputvalidation.priceValidation("asd"));
	}

	@Test
	@DisplayName("valid salary validation")
	void testSalaryValidation() {
		assertEquals(true, inputvalidation.salaryValidation("25000"));
	}

	@Test
	@DisplayName("Invalid salary validation")
	void testSalaryValidation1() {
		assertEquals(false, inputvalidation.salaryValidation("asdf"));
	}

}


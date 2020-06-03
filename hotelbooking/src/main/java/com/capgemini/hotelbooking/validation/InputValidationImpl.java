package com.capgemini.hotelbooking.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
*
* This class contains Implementation of Inputvalidation Interface and its abstract method
* 
*/
public class InputValidationImpl implements InputValidation {

	Pattern pat = null;
	Matcher mat = null;

	public boolean choiceValidate1(String choice) {

		pat = Pattern.compile("[1-9]");
		mat = pat.matcher(choice);
		if (mat.matches()) {
			return true;
		}

		return false;
	}

	public boolean usernameValidation(String username) {

		String regex = "^[0-a-z9_-]{3,14}$";

		pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		mat = pat.matcher(username);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param name
	 */

	public boolean nameValidation(String name) {
		String regex = "[a-z][A-z]*+\\s[a-z][A-z]*+";

		pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;

	}

	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param Contactnumber
	 */

	public boolean phonenumberValidation(String Contactnumber) {

		pat = Pattern.compile("^[6789]{1}\\d{9}$");
		mat = pat.matcher(Contactnumber);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param mail
	 */

	public boolean emailValidation(String email) {

		pat = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		}

		return false;
	}

	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param password
	 */

	public boolean passwordValidation(String password) {
		pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		mat = pat.matcher(password);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public boolean dateValidation(String date) {
		pat = Pattern.compile("[0-9]{4}-(0[1-9]|1[0-2])-(3[0-1]|[1-2][0-9]|0[0-9])");
		mat = pat.matcher(date);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hotelNumbervalidation(String hotelNumber) {
		pat = Pattern.compile("\\d{1,2}");
		mat = pat.matcher(hotelNumber);
		if (mat.matches()) {
			return true;
		}
		return false;
	}
	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param price
	 */

	public boolean priceValidation(String price) {
		pat = Pattern.compile("\\d{4,5}");
		mat = pat.matcher(price);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This Method will check whether the given string is matched or not
	 * 
	 * @return true when matches
	 * 
	 * @return false when not matches
	 * 
	 * @param salary
	 */
	public boolean salaryValidation(String salary) {
		pat = Pattern.compile("\\d{5,6}");
		mat = pat.matcher(salary);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

}

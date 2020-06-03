package com.capgemini.hotelbooking.validation;
/**
 * This is an Interface of inputvalidation 
 * 
 * 
 * @ return boolean
 *
 */
public interface InputValidation {
	public boolean choiceValidate1(String choice);

	public boolean usernameValidation(String username);

	public boolean nameValidation(String name);

	public boolean phonenumberValidation(String Contactnumber);

	public boolean emailValidation(String mail);

	public boolean passwordValidation(String password);

	public boolean dateValidation(String date);

	public boolean hotelNumbervalidation(String hotelNumber);

	boolean salaryValidation(String salary);

	boolean priceValidation(String price);

}

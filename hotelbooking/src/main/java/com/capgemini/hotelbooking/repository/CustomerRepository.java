package com.capgemini.hotelbooking.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.factory.Factory;
/**
 * This class contains the registration detail of customer 
 * 
 * @author Ritwik
 *
 */
public class CustomerRepository {
	public List<Customer> getCustomerInformationList() {
	List<Customer> customer = new ArrayList<Customer>();


		Customer customerregistration = Factory.getCustomerInstance();
		customerregistration.setUserName("ritwik");
		customerregistration.setName("Ritwik Yadav");
		customerregistration.setEmailId("ritwik@gmail.com");
		customerregistration.setPhoneNumber(8109332048l);
		customerregistration.setPassword("Ritwik@567");
		customer.add(customerregistration);


		return customer;

	}

}



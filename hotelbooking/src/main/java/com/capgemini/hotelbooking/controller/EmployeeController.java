package com.capgemini.hotelbooking.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Employee;
import com.capgemini.hotelbooking.exception.InvalidLoginDetailsException;
import com.capgemini.hotelbooking.exception.RegistrationFailedException;
import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.service.HotelService;
/**
 * This is a controller class of employee module employee can book a hotel to
 * customer and he can see the customers who are present in the application
 * 
 * @author Ritwik
 *
 */

public class EmployeeController {

	static Scanner scanner = new Scanner(System.in);

	static final Logger log = Logger.getLogger(EmployeeController.class);
	static HotelService service = Factory.getHotelServiceInstance();

	public static void operateEmployeeFunction() {

		log.info("Welcome");
		log.info("Select any one option to proceed");

		L: do {
			log.info("1.Login");
			log.info("2.Exit to Home Page");

			log.info("Select any one option (1-2)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-2)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				log.info("Enter Your username");
				String userName = scanner.nextLine();
				log.info("Enter Your password");
				String password = scanner.nextLine();
				boolean check = service.employeeLoginDetail(userName, password);
				try {
					if (check == true) {
						log.info("login done");
						employeeOperationFunction(userName);

					} else {
						throw new InvalidLoginDetailsException();
					}
				} catch (InvalidLoginDetailsException exception) {
					log.error(exception.requriedMessage());
				}
				break;
			case 2:
				break L;
			default:
				log.info("Select any one option (1-2)");
				break;
			}

		} while (true);
	}

	/**
	 * This method shows the operations that employee can perform
	 * 
	 * @param username
	 */

	public static void employeeOperationFunction(String username) {
		L: do {
			log.info("Select any one option to proceed");
			log.info("1.BookHotel");
			log.info("2.CustomerDetail");
			log.info("3.Logout");
			log.info("Select any one option (1-3)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-3)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				CustomerController.checkLocationInfo(username);
				break;
			case 2:
				getCustomerDetail();
				break;
			case 3:
				break L;

			default:
				log.info("Select any one option (1-3)");
				break;
			}

		} while (true);

	}

	public static void getCustomerDetail() {
		List<Customer> list = service.getAllCustomers();
		for (Customer customerinfo : list) {
			if (list == null) {
				log.info("Customer is not registered");
			} else {
				log.info(customerinfo);
			}
		}

	}

	/**
	 * this method shows the crud operation on employee like add, update and delete employee
	 */

	public static void employeeOperation() {
		L: do {
			log.info("Select any one option to proceed");
			log.info("1.add employee");
			log.info("2.delete employee");
			log.info("3.update employee");
			log.info("4.Get all employees");
			log.info("5.back");
			log.info("Select any one option (1-4)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-4)");
				choice1 = scanner.nextLine();

			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				addEmployeeDetail();
				break;
			case 2:
				deleteEmployeeDetail();
				break;
			case 3:
				updateEmployeeDetail();
				break;
			case 4:
				getEmployeeDetail();
				break;
			case 5:
				break L;
			default:
				log.info("Select any one option (1-4)");
				break;
			}
		} while (true);
	}

	/**
	 * This method is performed by admin to add employee by
	 * taking requried details
	 * 
	 */

	public static void addEmployeeDetail() {

		log.info("Enter details of employee");
		log.info(
				"Enter  username [ can have letters, numbers,specialcharacters but length should be (3-14)])");
		String userName = scanner.nextLine();
		while (service.checkUserNameForEmployee(userName)) {
			log.info("username already exists, try with new username");
			userName = scanner.nextLine();
			while (!service.userName(userName)) {

				log.info(
						"Enter Your username [ can have letters, numbers,specialcharacters but length should be (3-14)])");
				userName = scanner.nextLine();

			}
		}

		log.info("Enter your name (like firstname and lastname and having only letters)");
		String name = scanner.nextLine();

		while (!service.nameVerify(name)) {
			log.info("Enter your valid name (like firstname and lastname and having only letters)");
			name = scanner.nextLine();

		}

		log.info("Enter mailid (eg: abc@abc.abc)");
		String mail = scanner.nextLine();
		while (!service.emailId(mail)) {

			log.info("Enter valid mailid (eg: abc@abc.abc)");
			mail = scanner.nextLine();

		}
		log.info("Enter your phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
		String phoneNumber = scanner.nextLine();
		while (!service.phoneNumber(phoneNumber)) {
			log.info("Enter your valid phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
			phoneNumber = scanner.nextLine();

		}
		long phonenumber = Long.parseLong(phoneNumber);
		log.info(
				"Enter password (It should contains atleast one  uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
		String password = scanner.nextLine();
		while (!service.password(password)) {
			log.info(
					"Enter valid password (It should contains atleast one uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
			password = scanner.nextLine();

		}
		log.info("Enter Employee salary(it should have 4-5 digits)");
		String salary = scanner.nextLine();
		while (!service.salaryVerify(salary)) {
			log.info("Enter valid Employee salary(it should have 4-5 digits)");
			salary = scanner.nextLine();

		}
		int sala = Integer.parseInt(salary);

		boolean employee = service.addEmployeeInfo(userName, name, mail, phonenumber, password, sala);
		try {
			if (employee == true) {
				log.info("employee added");
			} else {
				throw new RegistrationFailedException();
			}
		} catch (RegistrationFailedException e) {
			log.error(e.requriedMessage());
		}

	}

	/**
	 * This method will give the list of employees present in the application
	 */

	public static void getEmployeeDetail() {
		List<Employee> list = service.getAllEmployees();
		for (Employee employeeinfo : list) {

			log.info(employeeinfo);
		}

	}

	/**
	 * This method is used  to delete a employee from the application
	 */

	public static void deleteEmployeeDetail() {
		log.info("Enter user name");
		String username = scanner.nextLine();
		boolean emp = service.employeeDeleteInfo(username);
		if (emp == true) {
			log.info("Employee deleted");
		} else {
			log.info("Employee not deleted");
		}
	}

	/**
	 * This method is used to update the employee details when ever requried
	 */

	public static void updateEmployeeDetail() {
		log.info("Enter user name");
		String username = scanner.nextLine();
		boolean empl = service.checkEmployeeUpdateInfo(username);
		if (empl == true) {
			log.info("Update employee");
			employeeUpdateDetail(username);
		} else {
			log.info("username not found");
		}

	}

	public static void employeeUpdateDetail(String userName) {

		log.info("Enter your name (like firstname and lastname and having only letters)");
		String name = scanner.nextLine();

		while (!service.nameVerify(name)) {
			log.info("Enter your valid name (like firstname and lastname and having only letters)");
			name = scanner.nextLine();

		}

		log.info("Enter emailid (eg: abc@abc.abc");
		String mail = scanner.nextLine();
		while (!service.emailId(mail)) {

			log.info("Enter valid mailid (eg: abc@abc.abc)");
			mail = scanner.nextLine();

		}
		log.info("Enter your phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
		String phoneNumber = scanner.nextLine();
		while (!service.phoneNumber(phoneNumber)) {
			log.info("Enter your valid phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
			phoneNumber = scanner.nextLine();

		}
		long phonenumber = Long.parseLong(phoneNumber);
		log.info(
				"Enter password (It should contains atleast one  uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
		String password = scanner.nextLine();
		while (!service.password(password)) {
			log.info(
					"Enter valid password (It should contains atleast one  uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
			password = scanner.nextLine();

		}
		log.info("Enter Employee salary(it should have 4-5 digits)");
		String salary = scanner.nextLine();
		while (!service.salaryVerify(salary)) {
			log.info("Enter valid Employee salary(it should have 4-5 digits)");
			salary = scanner.nextLine();

		}
		int sala = Integer.parseInt(salary);
		boolean employe = service.updateEmployeeInfo(userName, name, mail, phonenumber, password, sala);
		if (employe == true) {
			log.info("update sucessfull");
		} else {
			log.info("update failed");
		}
	}

}

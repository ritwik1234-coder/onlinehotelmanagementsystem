package com.capgemini.hotelbooking.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.service.HotelService;

/**
 * 
 * This class contains method which is used to start our program
 * 
 * @author Ritwik
 *
 */
public class HotelMainController {

	static final Logger log = Logger.getLogger(HotelMainController.class);

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		log.info("Feel good to fill application");

		log.info("Select any one option to proceed");

		HotelService hotelservice = Factory.getHotelServiceInstance();

		L: do {
			log.info("1.Admin");
			log.info("2.Employee");
			log.info("3.Customer");
			log.info("4.Exit");


			log.info("Select the option to perform operation you want");

			String choice1 = scanner.nextLine();
			while (!hotelservice.choiceVerify(choice1)) {
				log.info("Enter valid chioce (1-4)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);

			switch (choice) {

			case 1:
				try {
					AdminController.operateAdminFunction();
				} catch (Exception e) {
					log.info(e.getMessage());
				}
				break;
			case 2:
				EmployeeController.operateEmployeeFunction();
				break;
			case 3:
				CustomerController.operateCustomerFunction();

				break;
			case 4:
				break L;
			default:
				log.info("Enter valid chioce (1-4)");
				break;

			}
		} while (true);
		log.info("Thank You");
		scanner.close();

	}
}

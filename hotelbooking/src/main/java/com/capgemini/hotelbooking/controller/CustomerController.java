package com.capgemini.hotelbooking.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Customer;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
import com.capgemini.hotelbooking.exception.BookingNotDoneException;
import com.capgemini.hotelbooking.exception.HotelNumberNotFoundException;
import com.capgemini.hotelbooking.exception.InvalidLoginDetailsException;
import com.capgemini.hotelbooking.exception.RegistrationFailedException;
import com.capgemini.hotelbooking.exception.RoomNotFoundException;
import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.service.HotelService;

/**
 * This class is a controller of customer module.
 * 
 * it will show the operations that customer can perform
 * 
 * @author Ritwik
 *
 */

public class CustomerController {

	static Scanner scanner = new Scanner(System.in);

	static final Logger log = Logger.getLogger(CustomerController.class);

	/**
	 * This method will show the operations that customer can perform he can book
	 * hotel and check his booking status and he can update his password
	 * 
	 * If he is a new customer he should first register into the application and than he can access all
	 * the above oprations
	 * 
	 */

	public static void operateCustomerFunction() {

		Customer customerinformation = Factory.getCustomerInstance();

		HotelService service = Factory.getHotelServiceInstance();
		log.info("Welcome");
		log.info("Select any one option to proceed");

		L: do {
			log.info("1.Login");
			log.info("2.Register");
			log.info("3.Forgot password");
			log.info("4.Exit");
			log.info("Enter your choice (1-4)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Enter valid choice (1-4)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);

			switch (choice) {

			case 1:
				log.info("Enter Your username");
				String userName = scanner.nextLine();
				log.info("Enter Your password");
				String password = scanner.nextLine();
				boolean add = service.loginDetail(userName, password);
				try {
					if (add == true) {
						log.info("login done");
						customerHotelFunction(userName);
					} else {
						throw new InvalidLoginDetailsException();
					}
				} catch (InvalidLoginDetailsException exception) {
					log.error(exception.requriedMessage());
				}
				break;
			case 2:

				log.info("Enter your details to register");
				log.info(
						"Enter Your username [ can have letters, numbers,specialcharacters but length should be (3-14)])");
				userName = scanner.nextLine();
				while (service.checkUserNameForRegistration(userName)) {
					log.info("username already exists please try new username");
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
					log.info("Enter your name (like firstname and lastname and having only letters)");
					name = scanner.nextLine();

				}

				log.info("Enter mailid (eg: abc@abc.abc)");
				String mail = scanner.nextLine();
				while (!service.emailId(mail)) {

					log.info("Enter mailid (eg: abc@abc.abc)");
					mail = scanner.nextLine();

				}
				log.info("Enter your phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
				String phoneNumber = scanner.nextLine();
				while (!service.phoneNumber(phoneNumber)) {
					log.info("Enter your phone number(must have 10 digits and starting with 6 or 7 or 8 or 9)");
					phoneNumber = scanner.nextLine();

				}
				long phonenumber = Long.parseLong(phoneNumber);
				log.info(
						"Enter valid password (must have atleast one uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
				password = scanner.nextLine();
				while (!service.password(password)) {
					log.info(
							"Enter valid password (must have atleast one uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
					password = scanner.nextLine();

				}

				customerinformation.setUserName(userName);
				customerinformation.setName(name);
				customerinformation.setEmailId(mail);
				customerinformation.setPhoneNumber(phonenumber);
				customerinformation.setPassword(password);

				boolean add1 = service.addCustomerInfo(userName, name, mail, phonenumber, password);
				try {
					if (add1 == true) {
						log.info("Registration done");
					} else {
						throw new RegistrationFailedException();
					}
				} catch (RegistrationFailedException exception1) {
					log.error(exception1.requriedMessage());
				}

				break;
			case 3:
				log.info("Enter your username to update password");
				userName = scanner.nextLine();
				boolean add2 = service.createPassword(userName);
				if (add2) {
					log.info("UserName found");
					log.info("Enter your password");
					password = scanner.nextLine();
					while (!service.password(password)) {
						log.info(
								"Enter valid password (must have atleast one uppercase letter and lowercase letter, atleast one number,and specialcharacter(@)");
						password = scanner.nextLine();
					}
					boolean add3 = service.updatePassword(userName, password);
					if (add3) {
						log.info("Password updated");
					} else {
						log.info("password update done");
					}

				} else {
					log.info("UserName not found, try again");
				}
				break;
			case 4:
				break L;
			default:
				log.info("Enter valid choice (1-4)");
				break;

			}

		} while (true);

	}

	/**
	 * This method is used by customer to book a hotel or to  check his status after login
	 * 
	 * @param username
	 */

	public static void customerHotelFunction(String username) {
		HotelService service = Factory.getHotelServiceInstance();
		K: do {
			log.info("Select any one option you want to perform");
			log.info("1.Booking Hotel");
			log.info("2.Booking Status");
			log.info("3.logout");
			log.info("Enter your choice (1-3)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Enter valid choice (1-3)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);

			switch (choice) {
			case 1:
				checkLocationInfo(username);
				break;
			case 2:
				List<Booking> list = service.checkBookingInfo(username);
				try {
					if (list == null) {
						throw new BookingNotDoneException();
					} else {
						for (Booking bookinginfo : list) {

							log.info(bookinginfo);
						}
					}
				} catch (BookingNotDoneException exception) {
					log.error(exception.requriedMessage());
				}
				break;
			case 3:
				break K;
			default:
				log.info("Enter valid choice (1-3)");
				break;
			}

		} while (true);
	}

	/**
	 * This method will show the hotel locations that customer can choose 
	 *  and can book there room in a particular hotel
	 * 
	 * @param username
	 */
	public static void checkLocationInfo(String username) {
		HotelService service = Factory.getHotelServiceInstance();
		K: do {
			log.info("Select location ");
			log.info("1.chennai");
			log.info("2.pondicherry");
			log.info("3.back");
			log.info("Select any one option (1-3)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select valid choice (1-3)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				List<Hotel> list1 = service.getHotelInfo("chennai");
				if (list1 == null) {
					log.info("Location not available");
				} else {
					checkHotelInfo(list1, username, "chennai");
				}

				break;
			case 2:
				List<Hotel> list2 = service.getHotelInfo("pondicherry");
				if (list2 == null) {
					log.info("location not available");
				} else {
					checkHotelInfo(list2, username, "pondicherry");
				}
				break;
			case 3:
				break K;
			default:
				log.info("Enter valid choice (1-3)");
				break;

			}
		} while (true);
	}

	/**
	 * After selecting location they will enter into this method which 
	 * shows the list of hotels present in the selected location
	 * 
	 * @param hotellist
	 * @param username
	 * @param location
	 * @return
	 */

	public static List<Hotel> checkHotelInfo(List<Hotel> hotellist, String username,
			String location) {

		HotelService service = Factory.getHotelServiceInstance();

		log.info("List of Hotels in " + location);
		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "   " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		String hname = null;
		List<Room> list1 = service.checkRooms(location, hotelNumber);
		for (Room roominfo : list1) {
			hname = roominfo.getHotelName();
		}
		try {
			if (list1 == null) {
				throw new HotelNumberNotFoundException();
			} else {
				checkRoomInfo(username, list1, hotelNumber, location, hname);
			}
		} catch (HotelNumberNotFoundException exception) {
			log.error(exception.requriedMessage());
		}

		return hotellist;

	}

	/**
	 * This method will show the rooms present in the selected hotels
	 * 
	 * @param username
	 * @param room
	 * @param hotelNumber
	 * @param location
	 * @param hotelName
	 */
	public static void checkRoomInfo(String username, List<Room> room, String hotelNumber, String location,
			String hotelName) {

		HotelService service = Factory.getHotelServiceInstance();

		log.info("Available rooms for use");
		log.info("Roomtype" + "  " + "Roomprice");

		for (Room roominfo : room) {
			log.info(roominfo.getRoomType() + "   " + roominfo.getPrice());

		}

		log.info("Select Room Type Requried");
		log.info("1.Single sitter(For Two Members)");
		log.info("2.Double sitter(For Four Members)");
		log.info("3.back");

		log.info("Select any one option (1-3)");
		String choice1 = scanner.nextLine();
		while (!service.choiceVerify(choice1)) {
			log.info("Select any one option (1-3)");
			choice1 = scanner.nextLine();

		}

		int choice = Integer.parseInt(choice1);

		M: switch (choice) {
		case 1:
			String roomType1 = "Single sitter";
			double price = 0;
			List<Room> list1 = service.bookingRoom(roomType1, hotelNumber, location);

			if (list1 == null) {
				log.info("Room not found");
			} else {
				for (Room roominfo : list1) {
					price = roominfo.getPrice();
				}
				startBooking(username, roomType1, hotelName, price);
			}

			break;

		case 2:
			String roomType2 = "Double sitter";
			double price1 = 0;
			List<Room> list2 = service.bookingRoom(roomType2, hotelNumber, location);

			try {
				if (list2 == null) {
					throw new RoomNotFoundException();
				} else {
					for (Room roominfo : list2) {
						price1 = roominfo.getPrice();
					}
					startBooking(username, roomType2, hotelName, price1);
				}
			} catch (RoomNotFoundException e) {
				log.error(e.requriedMessage());
			}

			break;

		case 3:
			break M;
		default:
			log.info("Select any one option (1-3)");
			break;
		}

	}

	/**
	 * After selecting room customer will move to booking
	 * 
	 * in this method customer should provide required information to book hotel like checkin
	 * date,checkout date etc
	 * 
	 * @param username
	 * @param roomtype
	 * @param hotelName
	 * @param price
	 */

	public static void startBooking(String username, String roomtype, String hotelName, double price) {
		HotelService service = Factory.getHotelServiceInstance();

		Booking bookinginfo = Factory.getBookingInstance();

		log.info("Enter required details to book hotel");
		log.info("Enter name of the booking person (First and Last name having only letters)");

		String name = scanner.nextLine();
		while (!service.nameVerify(name)) {
			log.info("Enter valid name (First and Last name having only letters)");
			name = scanner.nextLine();
		}

		log.info("Enter phone number (must have 10 numbers and starting with 6 or 7 or 8 or 9)");
		String phoneNumber = scanner.nextLine();
		while (!service.phoneNumber(phoneNumber)) {
			log.info("Enter phone number (must have 10 numbers and starting with 6 or 7 or 8 or 9)");
			phoneNumber = scanner.nextLine();
		}
		long phonenumber = Long.parseLong(phoneNumber);
		LocalDate checkin = null;
		boolean check = true;
		boolean check1 = true;
		while (check == true) {

			log.info("Enter check-in date in the given format(yyyy-mm-dd))");
			String datein = scanner.nextLine();
			while (!service.verifyDate(datein)) {
				log.info("Enter vaild date in the given format(yyyy-mm-dd)");
				datein = scanner.nextLine();
			}
			try {
				checkin = LocalDate.parse(datein);
				while (checkin.isBefore(LocalDate.now())) {
					log.info("Check-in date should be present date or future date");
					datein = scanner.nextLine();
					while (!service.verifyDate(datein)) {
						log.info("Enter valid date");
					}

					checkin = LocalDate.parse(datein);
				}
				check = false;

			} catch (DateTimeParseException e) {
				log.error("Entered date is not present in the calender enter valid date in the given format(yyyy-mm-dd)");
				check = true;

			}

		}
		LocalDate checkout = null;
		while (check1 == true) {

			log.info("Enter check-out date (yyyy-mm-dd)");
			String dateout = scanner.nextLine();
			while (!service.verifyDate(dateout)) {
				log.info("Enter vaild date in the given format(yyyy-mm-dd)");
				dateout = scanner.nextLine();
			}
			try {
				checkout = LocalDate.parse(dateout);
				while (checkout.isBefore(checkin)) {
					log.info("Check-out date should be checkindate or future date");
					dateout = scanner.nextLine();
					while (!service.verifyDate(dateout)) {
					}
					log.info("Enter valid date");
					checkout = LocalDate.parse(dateout);
				}
				check1 = false;
			} catch (DateTimeParseException e) {
				log.error("Entered date is not present in the calender enter valid date in the given format(yyyy-mm-dd)");
				check1 = true;

			}

		}

		log.info("Select payment mode");
		log.info("1.Online");
		log.info("2.Cash");
		log.info("Select any one option (1-2)");
		String choice1 = scanner.nextLine();
		while (!service.choiceVerify(choice1)) {
			log.info("Select any one option (1-2)");
			choice1 = scanner.nextLine();
		}
		int choice = Integer.parseInt(choice1);
		switch (choice) {
		case 1:
			String payment = "online";
			bookinginfo.setPaymentMode(payment);
			break;
		case 2:
			String payment1 = "Cash";
			bookinginfo.setPaymentMode(payment1);
			break;
		default:
			log.info("Select any one option (1-2)");
			break;
		}

		bookinginfo.setBookedUserName(username);
		bookinginfo.setBookedName(name);
		bookinginfo.setBookedNumber(phonenumber);
		bookinginfo.setBookedHotel(hotelName);
		bookinginfo.setBookedRoomType(roomtype);
		bookinginfo.setBookedPrice(price);
		bookinginfo.setBookedDate(LocalDate.now());
		bookinginfo.setCheckinDate(checkin);
		bookinginfo.setCheckoutDate(checkout);

		boolean check2 = service.bookingDetail(bookinginfo);
		if (check2 == true) {
			log.info("Booking done");
			log.info(bookinginfo.toString());

		} else {
			log.info("Booking failed");
		}
	}
}
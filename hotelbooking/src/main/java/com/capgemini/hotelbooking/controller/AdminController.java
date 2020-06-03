package com.capgemini.hotelbooking.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.hotelbooking.bean.Booking;
import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.bean.Room;
import com.capgemini.hotelbooking.exception.BookingNotDoneException;
import com.capgemini.hotelbooking.exception.RegistrationFailedException;
import com.capgemini.hotelbooking.factory.Factory;
import com.capgemini.hotelbooking.service.HotelService;
/**
 * This is controller class of admin module  
 * 
 * In this class the operation done by the admin is crontrolled
 * 
 */
public class AdminController {

	static Scanner scanner = new Scanner(System.in);

	static final Logger log = Logger.getLogger(AdminController.class);

	static HotelService service = Factory.getHotelServiceInstance();

	/**
	 * this method is used by admin for login and to perform his task
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public static void operateAdminFunction() throws FileNotFoundException, IOException {

		log.info("Hello Admin");
		log.info("Select the required choice");

		L: do {
			log.info("1.Login");
			log.info("2.Exit");

			log.info("Select the option in (1-2)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select the choice (1-2)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				log.info("Enter Your username");
				String userName = scanner.nextLine();
				log.info("Enter Your password");
				String password = scanner.nextLine();
				boolean check = service.adminLoginDetail(userName, password);
				if (check == true ) {
					log.info("Login done");
					adminOperationFunction();
				} else {
					log.info("Login failed, try again");
				}

				break;
			case 2:
				break L;
			default:
				log.info("Select the choice (1-2)");
				break;

			}

		} while (true);
	}

	/**
	 * This method display the operations that admin performs
	 * 
	 * admin selects operation based on his requriment
	 */

	public static void adminOperationFunction() {
		A: do {
			log.info("Select any one operation you want to access");
			log.info("1.Operate Hotels");
			log.info("2.Operate Rooms");
			log.info("3.Operate Employees");
			log.info("4.View List Of Hotels");
			log.info("5.Get All Rooms");
			log.info("6.View Patron List of Specific Hotel");
			log.info("7.View Booking On Specific Date");
			log.info("8.logout");

			log.info("Select any one option (1-8)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-8)");
				choice1 = scanner.nextLine();

			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				hotelOperationFunction();
				break;
			case 2:
				roomOperation();
				break;
			case 3:
				EmployeeController.employeeOperation();
				break;
			case 4:
				getHotelDetail();
				break;
			case 5:
				getRoomDetail();
				break;

			case 6:
				patronList();
				break;
			case 7:
				specificDate();
				break;
			case 8:
				break A;

			}
		} while (true);
	}

	/**
	 * this method shows crud operation of hotel
	 * 
	 * where we can add,update,delete hotels
	 */

	public static void hotelOperationFunction() {
		M: do {
			log.info("Select the operation you want to perform");
			log.info("1.add hotel");
			log.info("2.delete hotel");
			log.info("3.update hotel");
			log.info("4.back");
			log.info("Select any one option (1-4)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-4)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				log.info("Select location to add hotel");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice2 = scanner.nextLine();
				while (!service.choiceVerify(choice2)) {
					log.info("Select any one option (1-3)");
					choice2 = scanner.nextLine();
				}
				int choic = Integer.parseInt(choice2);
				V: switch (choic) {
				case 1:

					boolean check = service.checkLocationInfo("chennai");
					if (check == true) {
						addHotelDetail("chennai");
					} else {
						log.info("Location not found");
					}
					break;
				case 2:
					boolean check2 = service.checkLocationInfo("pondicherry");
					if (check2 == true) {
						addHotelDetail("pondicherry");
					} else {
						log.info("Location not found");
					}
					break;
				case 3:
					break V;
				default:
					log.info("Select any one option (1-3)");
					break;
				}

				break;
			case 2:
				log.info("Select location to delete hotel you want");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice3 = scanner.nextLine();
				while (!service.choiceVerify(choice3)) {
					log.info("Select any one option (1-3)");
					choice3 = scanner.nextLine();
				}
				int choic1 = Integer.parseInt(choice3);
				I: switch (choic1) {
				case 1:
					List<Hotel> list1 = service.getHotelInfo("chennai");
					deleteHotelDetail(list1, "chennai");
					break;
				case 2:
					List<Hotel> list2 = service.getHotelInfo("pondicherry");
					deleteHotelDetail(list2, "pondicherry");
					break;
				case 3:
					break I;
				default:
					log.info("Select any one option (1-3)");
					break;

				}
				break;
			case 3:
				log.info("Select location to update hotel you want");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice4 = scanner.nextLine();
				while (!service.choiceVerify(choice4)) {
					log.info("Select any one option (1-3)");
					choice4 = scanner.nextLine();
				}
				int choic2 = Integer.parseInt(choice4);
				I: switch (choic2) {
				case 1:
					List<Hotel> list1 = service.getHotelInfo("chennai");
					updateHotelDetail(list1, "chennai");
					break;
				case 2:
					List<Hotel> list2 = service.getHotelInfo("pondicherry");
					updateHotelDetail(list2, "pondicherry");
					break;
				case 3:
					break I;
				default:
					log.info("Select any one option (1-3)");
					break;

				}
				break;
			case 4:
				break M;
			default:
				log.info("Select any one option (1-3)");
				break;
			}

		} while (true);
	}

	/**
	 * In this method admin can add hotel by entering location
	 * 
	 * @param location
	 */

	public static void addHotelDetail(String location) {

		log.info("Enter Hotel number,it can be single or double digit number(1-99)");
		String hotelNumber = scanner.nextLine();
		while (service.checkHotelNumber(hotelNumber, location)) {
			log.info("hotel number given in this location is already exists");
			hotelNumber = scanner.nextLine();
		}
		while (!service.verifyHotelNumber(hotelNumber)) {
			log.info("Enter valid Hotel number, it can be single or double digit number(1-99)");
			hotelNumber = scanner.nextLine();

		}
		log.info("Enter hotel name, must be character(eg: Hotel Catorist)");
		String hotelName = scanner.nextLine();
		while (!service.nameVerify(hotelName)) {
			log.info("Enter valid hotel name, must be characters(eg: Hotel Catorist)");
			hotelName = scanner.nextLine();
		}
		log.info("Enter hotel email (eg: abc@abc.abc)");
		String mail = scanner.nextLine();
		while (!service.emailId(mail)) {
			log.info("Enter valid hotel email (eg: abc@abc.abc)");
			mail = scanner.nextLine();
		}

		log.info("Enter hotel phone number[must have 10 digits and starting with 6 or 7 or 8 or 9]");
		String phonenumber = scanner.nextLine();
		while (!service.phoneNumber(phonenumber)) {
			log.info("Enter valid hotel phone number[must have 10 digits and starting with 6 or 7 or 8 or 9]");
			phonenumber = scanner.nextLine();
		}
		Long phoneNumber = Long.parseLong(phonenumber);

		boolean hotel = service.addHotelInfo(hotelName, location, hotelNumber, mail, phoneNumber);
		try {
			if (hotel == true) {
				log.info("hotel added");
			} else {
				throw new RegistrationFailedException();
			}
		} catch (RegistrationFailedException exception1) {
			log.error(exception1.requriedMessage());
		}

	}

	public static void deleteHotelDetail(List<Hotel> hotellist, String location) {
		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "  " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		boolean checked = service.deleteHotelInfo(hotelNumber, location);

		if (checked == true) {
			log.info("hotel deleted");
		} else {
			log.info("hotel is not deleted give correct hotelnumber ");
		}

	}

	/**
	 * This method is used to update hotel
	 * 
	 * @param hotellist
	 * @param location
	 */

	public static void updateHotelDetail(List<Hotel> hotellist, String location) {
		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "   " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		boolean checks = service.updateHotelInfo(hotelNumber, location);

		if (checks == true) {
			log.info("hotel details matched");
			updateForHotelDetail(hotelNumber, location);
		} else {
			log.info("hotel not matched, give correct hotelnumber");
		}

	}

	public static void updateForHotelDetail(String hotelNumber, String location) {
		log.info("Enter hotel name, must have characters(eg: Catorist)");
		String hotelName = scanner.nextLine();
		while (!service.nameVerify(hotelName)) {
			log.info("Enter valid hotel name, must have characters(eg: Hotel Catorist)");
			hotelName = scanner.nextLine();
		}
		log.info("Enter hotel email (eg: abc@abc.abc)");
		String mail = scanner.nextLine();
		while (!service.emailId(mail)) {
			log.info("Enter valid hotel email (eg: abc@abc.abc)");
			mail = scanner.nextLine();
		}

		log.info("Enter hotel phone number[must have 10 digits and starting with 6 or 7 or 8 or 9]");
		String phonenumber = scanner.nextLine();
		while (!service.phoneNumber(phonenumber)) {
			log.info("Enter valid hotel phone number[must have 10 digits and starting with 6 or 7 or 8 or 9]");
			phonenumber = scanner.nextLine();
		}
		Long phoneNumber = Long.parseLong(phonenumber);
		boolean checks = service.updateForHotelInfo(hotelNumber, location, hotelName, mail, phoneNumber);
		if (checks == true) {
			log.info("hotel update done");
		} else {
			log.info("hotel update failed");
		}
	}

	/**
	 * This method is used to get all hotels present in the list
	 * 
	 */
	public static void getHotelDetail() {

		List<Hotel> list1 = service.getAllHotels();
		for (Hotel hotelinfo : list1) {

			if (list1 == null) {
				log.info("Hotels are not added");
			} else {
				log.info(hotelinfo);
			}
		}

	}

	/**
	 * this method is used to perform the requried crud operation oon rooms
	 */

	public static void roomOperation() {
		M: do {
			log.info("Select operation you want to perform on rooms");
			log.info("1.addroom");
			log.info("2.delete room");
			log.info("3.update room");
			log.info("4.get all rooms");
			log.info("5.back");
			log.info("Select any one option (1-5)");
			String choice1 = scanner.nextLine();
			while (!service.choiceVerify(choice1)) {
				log.info("Select any one option (1-5)");
				choice1 = scanner.nextLine();
			}
			int choice = Integer.parseInt(choice1);
			switch (choice) {
			case 1:
				log.info("Select location to addroom");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice3 = scanner.nextLine();
				while (!service.choiceVerify(choice3)) {
					log.info("Select any one option (1-3)");
					choice3 = scanner.nextLine();
				}
				int choic1 = Integer.parseInt(choice3);
				I: switch (choic1) {
				case 1:
					List<Hotel> list1 = service.getHotelInfo("chennai");
					addRoom(list1, "chennai");

					break;
				case 2:
					List<Hotel> list2 = service.getHotelInfo("pondicherry");
					addRoom(list2, "pondicherry");

					break;
				case 3:
					break I;
				default:
					log.info("Select any one option (1-3)");
					break;

				}

				break;
			case 2:
				log.info("Select location to delete room");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice4 = scanner.nextLine();
				while (!service.choiceVerify(choice4)) {
					log.info("Select any one option (1-3)");
					choice4 = scanner.nextLine();
				}
				int choic2 = Integer.parseInt(choice4);
				I: switch (choic2) {
				case 1:
					List<Hotel> list1 = service.getHotelInfo("chennai");
					deleteRoomDetail(list1, "chennai");
					break;
				case 2:
					List<Hotel> list2 = service.getHotelInfo("pondicherry");
					deleteRoomDetail(list2, "pondicherry");
					break;
				case 3:
					break I;
				default:
					log.info("Select any one option (1-3)");
					break;

				}
				break;
			case 3:
				log.info("Select location to update room");
				log.info("1.chennai");
				log.info("2.pondicherry");
				log.info("3.back");
				log.info("Select any one option (1-3)");
				String choice5 = scanner.nextLine();
				while (!service.choiceVerify(choice5)) {
					log.info("Select any one option (1-3)");
					choice4 = scanner.nextLine();
				}
				int choic3 = Integer.parseInt(choice5);
				I: switch (choic3) {
				case 1:
					List<Hotel> list1 = service.getHotelInfo("chennai");
					updateRoomDetail(list1, "chennai");
					break;
				case 2:
					List<Hotel> list2 = service.getHotelInfo("pondicherry");
					updateRoomDetail(list2, "pondicherry");
					break;
				case 3:
					break I;
				default:
					log.info("Select any one option (1-3)");
					break;
				}
				break;
			case 4:
				gellAllRoom();
				break;
			case 5:
				break M;
			default:
				log.info("Select any one option (1-4)");
				break;

			}
		} while (true);

	}

	/**
	 * This method is used to check the details to add room
	 * 
	 * @param hotellist
	 * @param location
	 */

	public static void addRoom(List<Hotel> hotellist, String location) {

		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "  " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		String hname = null;
		List<Hotel> list1 = service.checkRoomInfo(location, hotelNumber);

		List<Hotel> list2 = service.checkRoomInfo(location, hotelNumber);
		if (list2 == null) {
			log.info("Room details not found ");

		} else {
			log.info("Room details found");
			for (Hotel roominfo : list1) {
				hname = roominfo.getHotelName();
			}

			addRoomDetail(location, hotelNumber, hname);
		}

	}

	/**
	 * This method is used to add room in a particular hotels when the details
	 * matched in the above method
	 * 
	 * @param location
	 * @param hotelNumber
	 * @param hotelName
	 */

	public static void addRoomDetail(String location, String hotelNumber, String hotelName) {
		Room roominfo = Factory.getRoomInstance();
		log.info("Select room type");
		log.info("1.Single sitter");
		log.info("2.Double sitter");
		log.info("3.back");
		String choice3 = scanner.nextLine();
		while (!service.choiceVerify(choice3)) {
			log.info("Select any one option (1-3)");
			choice3 = scanner.nextLine();
		}
		int choice = Integer.parseInt(choice3);
		B: switch (choice) {
		case 1:
			String roomType = "Single sitter";
			double price = 10000;
			roominfo.setHotelLocation(location);
			roominfo.setHotelName(hotelName);
			roominfo.setHotelNumber(hotelNumber);
			roominfo.setRoomType(roomType);
			roominfo.setPrice(price);
			boolean add1 = service.addRoomInfo(location, hotelName, hotelNumber, roomType, price);

			try {
				if (add1 == true) {
					log.info("room added");
				} else {
					throw new RegistrationFailedException();
				}
			} catch (RegistrationFailedException exception1) {
				log.error(exception1.requriedMessage());
			}
			break;
		case 2:
			String roomType2 = "Double sitter";
			double price1 = 20000;
			roominfo.setHotelLocation(location);
			roominfo.setHotelName(hotelName);
			roominfo.setHotelNumber(hotelNumber);
			roominfo.setRoomType(roomType2);
			roominfo.setPrice(price1);
			boolean add2 = service.addRoomInfo(location, hotelName, hotelNumber, roomType2, price1);

			try {
				if (add2 == true) {
					log.info("room added");
				} else {
					throw new RegistrationFailedException();
				}
			} catch (RegistrationFailedException exception1) {
				log.error(exception1.requriedMessage());
			}
			break;
		case 3:
			break B;
		default:
			log.info("Select any one option (1-3)");
			break;

		}

	}

	/**
	 * This method is used to delete a particular room from a hotel
	 * 
	 * @param hotellist
	 * @param location
	 */
	public static void deleteRoomDetail(List<Hotel> hotellist, String location) {
		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "   " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		log.info("Select room type you want to delete");
		log.info("1.Single sitter");
		log.info("2.Double sitter");
		log.info("3.back");
		String choice3 = scanner.nextLine();
		while (!service.choiceVerify(choice3)) {
			log.info("Select any one option (1-3)");
			choice3 = scanner.nextLine();
		}
		int choice = Integer.parseInt(choice3);
		B: switch (choice) {
		case 1:
			String roomtype = "Single sitter";
			boolean room = service.deleteRoomInfo(location, hotelNumber, roomtype);
			if (room == true) {
				log.info("Room deleted");
			} else {
				log.info("Room is not deleted");
			}
		case 2:
			String roomtype1 = "Double sitter";
			boolean room1 = service.deleteRoomInfo(location, hotelNumber, roomtype1);
			if (room1 == true) {
				log.info("Room deleted");
			} else {
				log.info("Room is not deleted");
			}
			break;
		case 3:
			break B;
		default:
			log.info("Select any one option (1-3)");
			break;
		}

	}

	/**
	 * This method is used to update particular room of a hotel
	 * 
	 * @param hotellist
	 * @param location
	 */

	public static void updateRoomDetail(List<Hotel> hotellist, String location) {
		for (Hotel hotelinfo : hotellist) {

			log.info(hotelinfo.getHotelNumber() + "   " + hotelinfo.getHotelName());

		}

		log.info("Enter hotel number");
		String hotelNumber = scanner.nextLine();
		log.info("Select room type to update");
		log.info("1.Single sitter");
		log.info("2.Double sitter");
		log.info("3.back");
		String choice3 = scanner.nextLine();
		while (!service.choiceVerify(choice3)) {
			log.info("Select any one option (1-3)");
			choice3 = scanner.nextLine();
		}
		int choice = Integer.parseInt(choice3);
		B: switch (choice) {
		case 1:
			String roomType = "Single sitter";
			double price = 10000;
			boolean room1 = service.updateRoomInfo(location, hotelNumber, roomType, price);
			if (room1 == true) {
				log.info("update done");
			} else {
				log.info("update failed");
			}
			break;
		case 2:
			String roomType1 = "Double sitter";
			double price1 = 20000;
			boolean room2 = service.updateRoomInfo(location, hotelNumber, roomType1, price1);
			if (room2 == true) {
				log.info("update done");
			} else {
				log.info("update failed");
			}

			break;
		case 3:
			break B;
		default:
			log.info("Select any one option (1-3)");
			break;

		}
	}

	/**
	 * This method will return all the rooms available
	 */

	public static void getRoomDetail() {

		List<Room> list1 = service.getAllRooms();
		for (Room roominfo : list1) {

			log.info(roominfo);
		}

	}

	/**
	 * this method will return patron list of a specific hotel by serching hotel
	 * name
	 */

	public static void patronList() {
		log.info("Enter hotel name");
		String hotelName = scanner.nextLine();
		List<Booking> list = service.getPatronList(hotelName);

		try {
			if (list == null) {
				throw new BookingNotDoneException();
			} else {
				for (Booking booking : list) {
					log.info(booking);
				}

			}
		} catch (BookingNotDoneException e) {
			log.error(e.requriedMessage());
		}
	}

	/**
	 * this method is used to check the booking by check-in date
	 */

	public static void specificDate() {
		log.info("Enter the date requried in the given format(yyyy-mm-dd)");
		String date = scanner.nextLine();
		while (!service.verifyDate(date)) {
			log.info("Enter the valid date requried in the given format(yyyy-mm-dd)");
			date = scanner.nextLine();

		}
		LocalDate dates = LocalDate.parse(date);
		List<Booking> list = service.getDateRequried(dates);

		try {
			if (list == null) {
				throw new BookingNotDoneException();
			} else {
				for (Booking booking : list) {
					log.info(booking);
				}

			}
		} catch (BookingNotDoneException exception) {
			log.error(exception.requriedMessage());
		}
	}

	public static void gellAllRoom() {

		List<Room> list1 = service.getAllRooms();
		for (Room roominfo : list1) {

			if (list1 == null) {
				log.info("rooms are not added");
			} else {
				log.info(roominfo);
			}
		}

	}

}



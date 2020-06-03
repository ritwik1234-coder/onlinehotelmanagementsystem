package com.capgemini.hotelbooking.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelbooking.bean.Room;
/**
 * This class contains the room detail which are added to application
 * 
 * @author Ritwik
 *
 */
public class RoomRepository {
	public List<Room> getRoomInformationList() {
	List<Room> room = new ArrayList<Room>();


		Room roominfo = new Room();
		roominfo.setHotelNumber("1");
		roominfo.setHotelName("Hotel Catorist");

		roominfo.setRoomType("Single sitter");
		roominfo.setHotelLocation("pondicherry");
		roominfo.setPrice(10000);

		Room roominfo2 = new Room();
		roominfo2.setHotelNumber("1");
		roominfo2.setHotelName("Hotel Catorist");

		roominfo2.setRoomType("Double sitter");
		roominfo2.setHotelLocation("pondicherry");
		roominfo2.setPrice(20000);

		Room roominfo4 = new Room();
		roominfo4.setHotelNumber("2");
		roominfo4.setHotelName("Black Mamba");

		roominfo4.setRoomType("Single sitter");
		roominfo4.setHotelLocation("pondicherry");
		roominfo4.setPrice(10000);

		Room roominfo6 = new Room();
		roominfo6.setHotelNumber("2");
		roominfo6.setHotelName("Black Mamba");

		roominfo6.setRoomType("Double sitter");
		roominfo6.setHotelLocation("pondicherry");
		roominfo6.setPrice(20000);

		Room roominfo8 = new Room();
		roominfo8.setHotelNumber("1");
		roominfo8.setHotelName("Grazial Hotel");

		roominfo8.setRoomType("Single sitter");
		roominfo8.setHotelLocation("chennai");
		roominfo8.setPrice(10000);

		Room roominfo10 = new Room();
		roominfo10.setHotelNumber("1");
		roominfo10.setHotelName("Grazial Hotel");

		roominfo10.setRoomType("Double sitter");
		roominfo10.setHotelLocation("chennai");
		roominfo10.setPrice(20000);

		Room roominfo12 = new Room();
		roominfo12.setHotelNumber("2");
		roominfo12.setHotelName("Pavitra Hotel");

		roominfo12.setRoomType("Single sitter");
		roominfo12.setHotelLocation("chennai");
		roominfo12.setPrice(10000);

		Room roominfo14 = new Room();
		roominfo14.setHotelNumber("2");
		roominfo14.setHotelName("Pavitra Hotel");

		roominfo14.setRoomType("Double sitter");
		roominfo14.setHotelLocation("chennai");
		roominfo14.setPrice(20000);

		room.add(roominfo);
		room.add(roominfo2);
		room.add(roominfo4);
		room.add(roominfo6);
		room.add(roominfo8);
		room.add(roominfo10);
		room.add(roominfo12);
		room.add(roominfo14);

		return room;

	}

}



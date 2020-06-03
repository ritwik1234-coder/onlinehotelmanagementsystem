package com.capgemini.hotelbooking.repository;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.hotelbooking.bean.Hotel;
import com.capgemini.hotelbooking.factory.Factory;
/**
 * This class contains the hotel detail which are added to application
 * 
 * @author Ritwik
 *
 */
public class HotelRepository {
	public List<Hotel> getHotelInformationList() {
	List<Hotel> hotellist = new ArrayList<Hotel>();


		Hotel hotelinformation = Factory.getHotelInstance();
		hotelinformation.setHotelNumber("1");
		hotelinformation.setHotelName("Hotel Catorist ");
		hotelinformation.setLocation("pondicherry"); 
		hotelinformation.setEmailid("catorist@gmail.com");
		hotelinformation.setPhonenumber(8989898989l);

		Hotel hotelinformation1 = Factory.getHotelInstance();
		hotelinformation1.setHotelNumber("2");
		hotelinformation1.setHotelName("Black Mamba");
		hotelinformation1.setLocation("pondicherry");
		hotelinformation1.setEmailid("blackmamba@gmail.com");
		hotelinformation1.setPhonenumber(8989898990l);

		Hotel hotelinformation3 = Factory.getHotelInstance();
		hotelinformation3.setHotelNumber("1");
		hotelinformation3.setHotelName("Grazial Hotel");
		hotelinformation3.setLocation("chennai");
		hotelinformation3.setEmailid("grazial@gamil.com");
		hotelinformation3.setPhonenumber(8989898991l);

		Hotel hotelinformation4 = Factory.getHotelInstance();
		hotelinformation4.setHotelNumber("2");
		hotelinformation4.setHotelName("Pavitra Hotel");
		hotelinformation4.setLocation("chennai");
		hotelinformation4.setEmailid("pavitra@gamil.com");
		hotelinformation4.setPhonenumber(8989898992l);

		hotellist.add(hotelinformation);
		hotellist.add(hotelinformation1);
		hotellist.add(hotelinformation3);
		hotellist.add(hotelinformation4);

		return hotellist;

	}

}



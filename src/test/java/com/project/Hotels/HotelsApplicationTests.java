package com.project.Hotels;

import com.project.Hotels.entities.City;
import com.project.Hotels.entities.Hotel;
import com.project.Hotels.entities.Location;
import com.project.Hotels.repos.CityRepository;
import com.project.Hotels.repos.HotelRepository;
import com.project.Hotels.repos.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelsApplicationTests {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	LocationRepository locationRepository;

	@Test
	void contextLoads() {
	}
/*
	@Test
	public void createCity(){
		Location cityLocation = new Location();
		cityLocation.setX(90);
		cityLocation.setY(50);

		//locationRepository.save(cityLocation);

		City city = new City();
		city.setLocation(cityLocation);
		city.setName("Nablus");
		cityRepository.save(city);


	}

	@Test
	public void createHotel(){
		City city = cityRepository.findByName("Nablus");
		Location hotelLocation = new Location();
		hotelLocation.setX(85);
		hotelLocation.setY(40);

		Hotel hotel = new Hotel();
		hotel.setName("Relax");
		hotel.setLocation(hotelLocation);
		hotelLocation.setCity(city);

		Location hotelLocation2 = new Location();
		hotelLocation2.setX(95);
		hotelLocation2.setY(35);

		Hotel hotel2 = new Hotel();
		hotel2.setName("Wow");
		hotel2.setLocation(hotelLocation2);

		city.addHotel(hotel);
		city.addHotel(hotel2);

		cityRepository.save(city);

	}

 */
}

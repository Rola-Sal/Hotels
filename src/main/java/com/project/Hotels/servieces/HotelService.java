package com.project.Hotels.servieces;

import com.project.Hotels.entities.City;
import com.project.Hotels.entities.Hotel;
import com.project.Hotels.entities.Location;
import com.project.Hotels.repos.CityRepository;
import com.project.Hotels.repos.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    CityRepository cityRepository;

    public Set<String> getAllHotels(Integer cityId){
        Set<Hotel> hotels = new HashSet<>();
        Set<String> hotelName = new HashSet<>();
        hotelRepository.findByCityId(cityId)
                .forEach(hotels :: add);
        hotels.forEach(hotel -> hotelName.add(hotel.getName()));
        return hotelName;
    }

    public ArrayList<String> getAllNearestHotels(Integer cityId) {

        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.findAll()
                .forEach(hotels :: add);

        City city = cityRepository.findById(cityId).get();
        city.setHotelDistances(hotels);

        hotels.forEach(hotel -> hotelRepository.save(hotel));

        List<Hotel> sortedHotels;
        Sort sort = Sort.by(Sort.Direction.ASC, "distanceFromSpecificCity");
        sortedHotels = (List<Hotel>) hotelRepository.findAll(sort);


        ArrayList<String> hotelName = new ArrayList<String>();
        sortedHotels.forEach(hotel -> hotelName.add(hotel.getName()));

        //hotelName.forEach(name -> System.out.println(name));

        return hotelName;
    }

    public ArrayList<String> getAllNearestHotels(Integer cityId , Integer numberOfHotels) {

        Set<Hotel> hotels = new HashSet<>();
        hotelRepository.findAll()
                .forEach(hotels :: add);

        City city = cityRepository.findById(cityId).get();
        city.setHotelDistances(hotels);

        hotels.forEach(hotel -> hotelRepository.save(hotel));

        List<Hotel> sortedHotels;
        Sort sort = Sort.by(Sort.Direction.ASC, "distanceFromSpecificCity");
        sortedHotels = (List<Hotel>) hotelRepository.findAll(sort);


        ArrayList<String> hotelName = new ArrayList<String>();
        try {
            for(int i = 0 ; i < numberOfHotels ; i++){
                hotelName.add(sortedHotels.get(i).getName());
            }
        }
        catch (IndexOutOfBoundsException exception){
            hotelName.add("No more Hotels Exist");
        }

        //hotelName.forEach(name -> System.out.println(name));

        return hotelName;
    }

}

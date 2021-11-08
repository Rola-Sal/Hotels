package com.project.Hotels.servieces;


import com.project.Hotels.entities.City;
import com.project.Hotels.entities.Hotel;
import com.project.Hotels.repos.CityRepository;
import com.project.Hotels.repos.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;


    public List<City> getAllCities(){
        // return topics; //now we will return it from db using Repository
        List<City> cities = new ArrayList<City>();
        cityRepository.findAll()
                .forEach(cities :: add);
        return cities;
    }


}

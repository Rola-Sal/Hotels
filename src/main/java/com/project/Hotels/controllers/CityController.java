package com.project.Hotels.controllers;
import com.project.Hotels.entities.City;
import com.project.Hotels.entities.Hotel;
import com.project.Hotels.servieces.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("/cities") //get method as default
    public List<City> getAllTopics(){
        return cityService.getAllCities();
    }


}

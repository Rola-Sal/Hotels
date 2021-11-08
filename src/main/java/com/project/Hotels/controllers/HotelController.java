package com.project.Hotels.controllers;

import com.project.Hotels.entities.Hotel;
import com.project.Hotels.servieces.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("/cities/{id}/hotels") //get method as default
    public Set<String> getAllHotels(@PathVariable Integer id){
        return hotelService.getAllHotels(id);
    }

    @RequestMapping("/cities/{id}/nearestHotels") //get method as default
    public ArrayList<String> getAllNearestHotels(@PathVariable Integer id){
        return  hotelService.getAllNearestHotels(id);
    }

    @RequestMapping("/cities/{id}/nearestHotels/{number}") //get method as default
    public ArrayList<String> getAllNearestNumberHotels(@PathVariable Integer id , @PathVariable Integer number){
        return  hotelService.getAllNearestHotels(id , number);
    }
}

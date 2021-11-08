package com.project.Hotels.repos;

import com.project.Hotels.entities.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository extends CrudRepository<Hotel,Integer> {

     List<Hotel> findByCityId(Integer cityId);
}

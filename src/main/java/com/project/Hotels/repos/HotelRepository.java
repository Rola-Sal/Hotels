package com.project.Hotels.repos;

import com.project.Hotels.entities.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HotelRepository  extends PagingAndSortingRepository<Hotel , Integer > {

     List<Hotel> findByCityId(Integer cityId);
}

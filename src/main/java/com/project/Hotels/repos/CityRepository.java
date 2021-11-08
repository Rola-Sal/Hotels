package com.project.Hotels.repos;

import com.project.Hotels.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {
    public City findByName(String cityName);
}

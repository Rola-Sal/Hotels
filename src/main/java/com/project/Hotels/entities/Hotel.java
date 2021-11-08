package com.project.Hotels.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;

    //@JsonIgnoreProperties("hotel")
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    Location location ;



    Double distanceFromSpecificCity ;

    public Double getDistanceFromSpecificCity() {
        return distanceFromSpecificCity;
    }

    public void setDistanceFromSpecificCity(City city){
        double x1 = this.getLocation().getX();
        double y1 = this.getLocation().getY();
        double x2 = city.getLocation().getX();
        double y2 = city.getLocation().getY();

        distanceFromSpecificCity = Math.sqrt( Math.pow( (x1-x2) , 2) + Math.pow( (y1-y2), 2));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

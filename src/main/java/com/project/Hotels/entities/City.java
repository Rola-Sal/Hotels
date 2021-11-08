package com.project.Hotels.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //@JsonIgnoreProperties("city")
    @JsonManagedReference
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Hotel> hotels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    Location location;

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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addHotel(Hotel hotel){
        if(hotels == null)
            hotels = new HashSet<>();
        hotel.setCity(this);
        hotels.add(hotel);

    }

    public Hotel[] getNearestThreeHotels(Set<Hotel> hotels){

        double firstMin = Double.MAX_VALUE;
        double secMin = Double.MAX_VALUE;
        double thirdMin = Double.MAX_VALUE;

        Hotel firstHotel = new Hotel();
        Hotel secHotel = new Hotel();
        Hotel thirdHotel = new Hotel();

        double x1 , y1;
        double x2 = this.getLocation().getX();
        double y2 = this.getLocation().getY();
        double distance;

        for (Hotel hotel: hotels) {
             x1 = hotel.getLocation().getX();
             y1 = hotel.getLocation().getY();

            distance = Math.sqrt( Math.pow( (x1-x2) , 2) + Math.pow( (y1-y2), 2));
            System.out.println(hotel.getName() + " = " + distance);

            if(distance < firstMin){
                thirdMin = secMin;
                thirdHotel = secHotel;

                secMin = firstMin;
                secHotel = firstHotel;

                firstMin = distance;
                firstHotel = hotel;
            }

           else if (distance < secMin && distance >= firstMin)
            {
                thirdMin = secMin;
                thirdHotel = secHotel;
                secMin =distance;
                secHotel = hotel;

            }

            else if (distance < thirdMin && distance >= secMin)
            {
                thirdMin = distance;
                thirdHotel = hotel;
            }

        }

        Hotel[] nearestHotels = new Hotel[3];

        nearestHotels[0] = firstHotel;   System.out.println("first = " + firstHotel.getName());
        nearestHotels[1] = secHotel;    System.out.println("Second = " + secHotel.getName());
        nearestHotels[2] = thirdHotel;  System.out.println("Third = " + thirdHotel.getName());

        return nearestHotels;
    }
}

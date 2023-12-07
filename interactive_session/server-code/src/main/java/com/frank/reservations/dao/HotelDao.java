package com.frank.reservations.dao;

import com.frank.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getHotels();

    List<Hotel> getHotelsByStateAndCity(String state, String city);

    Hotel getHotelById(int id);

}

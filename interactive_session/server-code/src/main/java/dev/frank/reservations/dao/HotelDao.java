package dev.frank.reservations.dao;

import dev.frank.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getHotels();

    List<Hotel> getHotelsByStateAndCity(String state, String city);

    Hotel getHotelById(int id);

}

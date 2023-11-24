package com.frank.reservations.controllers;

import com.frank.reservations.dao.HotelDao;
import com.frank.reservations.dao.MemoryHotelDao;
import com.frank.reservations.dao.MemoryReservationDao;
import com.frank.reservations.dao.ReservationDao;
import com.frank.reservations.model.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HotelController {

    private HotelDao       hotelDao;
    private ReservationDao reservationDao;

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> list() {
        return new ResponseEntity(hotelDao.getHotels(), HttpStatus.OK);
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hotel> get(@PathVariable int id) {
        return new ResponseEntity(hotelDao.getHotelById(id), HttpStatus.OK);
    }

}

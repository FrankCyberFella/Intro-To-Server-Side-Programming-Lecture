package dev.frank.reservations.controllers;

import dev.frank.reservations.dao.HotelDao;
import dev.frank.reservations.model.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController

public class HotelController {

    private final HotelDao theHotelDataSource;

    public HotelController(HotelDao hotelDao) {
        this.theHotelDataSource = hotelDao;
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> list() {
        // Log path to server log with parameters omitting optional parameters if missing
        logAPICall("GET  - /hotels");

        return new ResponseEntity<>(theHotelDataSource.getHotels(), HttpStatus.OK);
    }

    /**
     * Return hotel information for a specific state and optional city
     *
     * @param state - Name of the state (NOT abbreviation)
     * @param city  - optional City within state
     * @return all info hotels in the given state and, optional, city combination
     */

    @RequestMapping(path="/hotels/filter", method=RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam String state
            ,@RequestParam(required = false) String city) {
        // Log path to server log with parameters omitting optional parameters if missing
        logAPICall("GET  - /hotels/filter?state=" + state + ((city != null) ? "&city=" + city : ""));

        return theHotelDataSource.getHotelsByStateAndCity(state, city);
    }

    /**
     * Return hotel information for a specific hotel is
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hotel> get(@PathVariable int id) {
        // Log path to server log with path variable
        logAPICall("GET  - /hotels/" + id);

        return new ResponseEntity<>(theHotelDataSource.getHotelById(id), HttpStatus.OK);
    }

    /****************************************************************************************************
     * Helper method to Write a message with a time stamp to the server log\
     *
     *  @param message - message to be appended to the timestamp in server console log
     ***************************************************************************************************/
    public void logAPICall(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
        String timeNow = now.format(formatter);
        System.out.println(timeNow + "-" + message);
    }


}

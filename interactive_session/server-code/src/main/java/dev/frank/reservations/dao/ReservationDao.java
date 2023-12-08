package dev.frank.reservations.dao;

import java.util.List;
import dev.frank.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> getReservations();

    List<Reservation> getReservationsByHotel(int hotelId);

    Reservation getReservationById(int reservationId);

    Reservation createReservation(Reservation reservation);

}

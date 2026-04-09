package com.example.CinemaBookingOnline.repository;

import com.example.CinemaBookingOnline.model.entity.Booking;
import com.example.CinemaBookingOnline.model.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

//    @Query("SELECT DISTINCT b FROM Booking" +
//            "JOIN b.seats WHERE b.screeningId = :screeningId AND s.id IN :seatIds AND b.status IN :statuses")
//    List<Booking> findConflictBookings(Long screeningId, Set<Long> seatIds, List<BookingStatus> statuses);
}

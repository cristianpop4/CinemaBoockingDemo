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

    @Query("""
            select distinct b
            from Booking b
            join b.seats s
            where b.screening.id = :screeningId
                and s.id in :seatIds
                and b.status in :statuses
            """)
    List<Booking> findConflictBookingJPQL(Long screeningId, Set<Long> seatIds, List<BookingStatus> statuses);

    @Query("""
            select count(b)
            from Booking b
            join b.seats s
            where b.screening.id = :screeningId
                and s.id in :seatIds
                and b.status in :statuses
            """)
    Long conflictCountBooking(Long screeningId, Set<Long> seatIds, List<BookingStatus> statuses);
}

package com.example.CinemaBookingOnline.repository;

import com.example.CinemaBookingOnline.model.entity.Screening;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByMovieId(Long id);
    List<Screening> findByCinemaRoomId(Long id);

    List<Screening> findByStartTimeBetween(LocalDate start, LocalDate end);

    @Query(
            "SELECT s FROM Screening s WHERE s.startTime BETWEEN:start AND :end"
    )
    List<Screening> getScreeningByPeriod(LocalDate start, LocalDate end);
}

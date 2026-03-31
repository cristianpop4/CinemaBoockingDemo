package com.example.CinemaBookingOnline.repository;

import com.example.CinemaBookingOnline.model.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}

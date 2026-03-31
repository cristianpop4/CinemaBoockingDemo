package com.example.CinemaBookingOnline.repository;

import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long> {
}

package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.SeatResponseDto;
import com.example.CinemaBookingOnline.model.entity.Seat;

import java.util.List;

public interface SeatService {
    List<SeatResponseDto> getAllSeatsByRoomId(Long id);
    SeatResponseDto getSeatById(Long id);

    default SeatResponseDto toDto(Seat seat){
        return new SeatResponseDto(
                seat.getId(),
                seat.getCinemaRoom().getName(),
                "position" + seat.getRowNumber() + "/" + seat.getColNumber()
        );
    }
}

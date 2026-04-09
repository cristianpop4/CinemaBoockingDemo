package com.example.CinemaBookingOnline.model.dto;

import com.example.CinemaBookingOnline.model.enums.BookingStatus;

import java.time.LocalDate;
import java.util.Set;

public record BookingResponseDto(
        Long id,
        String movieName,
        Long movieId,
        String cinemaRoomName,
        Set<Long> seatIds,
        LocalDate time,
        BookingStatus status
) { }

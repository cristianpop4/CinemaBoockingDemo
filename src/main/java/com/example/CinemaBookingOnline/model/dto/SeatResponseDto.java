package com.example.CinemaBookingOnline.model.dto;

public record SeatResponseDto(
        Long id,
        String cinemaRoomName,
        String position
) { }

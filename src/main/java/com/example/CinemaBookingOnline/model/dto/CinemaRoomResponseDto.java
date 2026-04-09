package com.example.CinemaBookingOnline.model.dto;

public record CinemaRoomResponseDto(
        Long id,
        Integer numberOfSeats,
        String name
) { }

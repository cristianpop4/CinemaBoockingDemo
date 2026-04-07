package com.example.CinemaBookingOnline.model.dto;

public record CinemaRoomRequestDto(
    Integer colsCount,
    Integer rowsCount,
    String name
) { }

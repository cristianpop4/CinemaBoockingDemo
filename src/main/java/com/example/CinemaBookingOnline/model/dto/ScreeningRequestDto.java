package com.example.CinemaBookingOnline.model.dto;

public record ScreeningRequestDto(
        Long movieId,
        Long roomId,
        Double price
) { }

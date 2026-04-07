package com.example.CinemaBookingOnline.model.dto;

public record MovieResponseDto(
        Long id,
        String title,
        Double rating,
        Integer releaseYear
) { }

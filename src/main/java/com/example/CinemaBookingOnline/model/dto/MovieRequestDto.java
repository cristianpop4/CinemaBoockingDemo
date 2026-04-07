package com.example.CinemaBookingOnline.model.dto;

public record MovieRequestDto(
        String title,
        Double rating,
        Integer releaseYear
) { }

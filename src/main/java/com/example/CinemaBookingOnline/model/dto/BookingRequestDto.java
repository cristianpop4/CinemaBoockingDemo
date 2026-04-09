package com.example.CinemaBookingOnline.model.dto;

import java.util.Set;

public record BookingRequestDto(
        Long screeningId,
        Set<Long> seatIds
) { }

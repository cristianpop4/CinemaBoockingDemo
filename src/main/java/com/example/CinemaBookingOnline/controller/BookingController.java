package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.dto.BookingRequestDto;
import com.example.CinemaBookingOnline.model.dto.BookingResponseDto;
import com.example.CinemaBookingOnline.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto dto){
        return bookingService.createBooking(dto);
    }
}

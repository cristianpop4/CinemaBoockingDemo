package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.BookingRequestDto;
import com.example.CinemaBookingOnline.model.dto.BookingResponseDto;
import com.example.CinemaBookingOnline.model.entity.Booking;
import com.example.CinemaBookingOnline.model.entity.Seat;

import java.util.stream.Collectors;

public interface BookingService {
    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto);
    BookingResponseDto confirmBooking(Long id);
    void cancelBooking(Long id);
    BookingResponseDto getBookingById(Long id);

    default BookingResponseDto toDto(Booking booking){
        return new BookingResponseDto(
                booking.getId(),
                booking.getScreening().getMovie().getTitle(),
                booking.getScreening().getMovie().getId(),
                booking.getScreening().getCinemaRoom().getName(),
                booking.getSeats()
                        .stream()
                        .map(Seat::getId)
                        .collect(Collectors.toSet()),
                booking.getCreatedAt(),
                booking.getStatus()
        );
    }
}

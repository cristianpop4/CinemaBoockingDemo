package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.BookingRequestDto;
import com.example.CinemaBookingOnline.model.dto.BookingResponseDto;
import com.example.CinemaBookingOnline.model.entity.Booking;
import com.example.CinemaBookingOnline.model.entity.Screening;
import com.example.CinemaBookingOnline.model.entity.Seat;
import com.example.CinemaBookingOnline.model.enums.BookingStatus;
import com.example.CinemaBookingOnline.repository.BookingRepository;
import com.example.CinemaBookingOnline.repository.ScreeningRepository;
import com.example.CinemaBookingOnline.repository.SeatRepository;
import com.example.CinemaBookingOnline.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final ScreeningRepository screeningRepository;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Screening screening = screeningRepository.findById(bookingRequestDto.screeningId())
                .orElseThrow(() -> new RuntimeException("Screening not found"));

        Set<Long> seats = bookingRequestDto.seatIds();
        if (seats == null || seats.isEmpty()) throw new RuntimeException("Seats ids invalid");

        List<Booking> conflicts = bookingRepository.findConflictBookingJPQL(bookingRequestDto.screeningId(), seats, List.of(BookingStatus.ONHOLD, BookingStatus.CONFIRMED));

        if (!conflicts.isEmpty()) {
            throw new RuntimeException("There are conflicts on your booking");
        }

        Long conflictsCount = bookingRepository.conflictCountBooking(bookingRequestDto.screeningId(), seats, List.of(BookingStatus.ONHOLD, BookingStatus.CONFIRMED));

        if (conflictsCount > 0) {
            throw new RuntimeException("There are conflicts on your booking");
        }

        Set<Seat> seatSet = seatRepository.findAllById(seats)
                .stream()
                .collect(Collectors.toSet());

        Booking booking = new Booking();
        booking.setScreening(screening);
        booking.setSeats(seatSet);
        booking.setCreatedAt(LocalDate.now());
        booking.setStatus(BookingStatus.ONHOLD);

        return toDto(bookingRepository.save(booking));
    }

    @Override
    public BookingResponseDto confirmBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.ONHOLD) {
            throw new RuntimeException("Booking status already changed pr cannot be confirmed");
        }
        booking.setStatus(BookingStatus.CONFIRMED);

        return toDto(bookingRepository.save(booking));
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELED);

        bookingRepository.save(booking);
    }

    @Override
    public BookingResponseDto getBookingById(Long id) {
        return toDto(bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found")));
    }
}

package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.SeatResponseDto;
import com.example.CinemaBookingOnline.repository.SeatRepository;
import com.example.CinemaBookingOnline.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;

    @Override
    public List<SeatResponseDto> getAllSeatsByRoomId(Long id) {
        return seatRepository.findByCinemaRoomId(id)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public SeatResponseDto getSeatById(Long id) {
        return toDto(seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found")));
    }
}

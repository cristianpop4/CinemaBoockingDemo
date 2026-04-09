package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.dto.SeatResponseDto;
import com.example.CinemaBookingOnline.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seats")
public class SeatController {
    private final SeatService service;

    @GetMapping("/room/{id}")
    public List<SeatResponseDto> getAllSeatsByRoomId(@PathVariable Long id){
        return service.getAllSeatsByRoomId(id);
    }

    @GetMapping("/{id}")
    public SeatResponseDto getSeatById(@PathVariable Long id){
        return service.getSeatById(id);
    }

}

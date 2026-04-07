package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.dto.CinemaRoomRequestDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import com.example.CinemaBookingOnline.service.CinemaRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemarooms")
@RequiredArgsConstructor
public class CinemaRoomController {
    private final CinemaRoomService cinemaRoomService;

    @PostMapping
    public CinemaRoom createRoom(@RequestBody CinemaRoomRequestDto dto){
        return cinemaRoomService.createRoom(dto);
    }

    @GetMapping
    public List<CinemaRoom> getAllRooms(){
        return cinemaRoomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public CinemaRoom getRoomById(@PathVariable Long id){
        return cinemaRoomService.getRoomById(id);
    }
}

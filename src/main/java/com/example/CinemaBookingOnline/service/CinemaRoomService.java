package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.CinemaRoomRequestDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    CinemaRoom createRoom(CinemaRoomRequestDto dto);
    List<CinemaRoom> getAllRooms();
    CinemaRoom getRoomById(Long id);


}

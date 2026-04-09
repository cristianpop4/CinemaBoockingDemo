package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.CinemaRoomRequestDto;
import com.example.CinemaBookingOnline.model.dto.CinemaRoomResponseDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    CinemaRoomResponseDto createRoom(CinemaRoomRequestDto dto);
    List<CinemaRoomResponseDto> getAllRooms();
    CinemaRoomResponseDto getRoomById(Long id);

    default CinemaRoomResponseDto toDto(CinemaRoom cinemaRoom){
        return new CinemaRoomResponseDto(
                cinemaRoom.getId(),
                cinemaRoom.getColsCount()*cinemaRoom.getRowsCount(),
                cinemaRoom.getName()
        );
    }
}

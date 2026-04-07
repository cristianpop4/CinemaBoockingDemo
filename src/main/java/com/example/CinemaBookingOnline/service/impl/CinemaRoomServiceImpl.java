package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.CinemaRoomRequestDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import com.example.CinemaBookingOnline.model.entity.Seat;
import com.example.CinemaBookingOnline.repository.CinemaRoomRepository;
import com.example.CinemaBookingOnline.repository.SeatRepository;
import com.example.CinemaBookingOnline.service.CinemaRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaRoomServiceImpl implements CinemaRoomService {
    private final CinemaRoomRepository cinemaRoomRepository;
    private final SeatRepository seatRepository;

    @Override
    public CinemaRoom createRoom(CinemaRoomRequestDto dto) {
        CinemaRoom room = new CinemaRoom();
        room.setColsCount(dto.colsCount());
        room.setRowsCount(dto.rowsCount());
        room.setName(dto.name());

        CinemaRoom roomSaved = cinemaRoomRepository.save(room);

        for (int row = 1 ; row <= roomSaved.getRowsCount() ; row++){
            for (int col = 1 ; col <= roomSaved.getColsCount() ; col++){
                Seat seat = new Seat();
                seat.setRowNumber(row);
                seat.setColNumber(col);
                seat.setCinemaRoom(roomSaved);

                seatRepository.save(seat);
            }
        }
        return roomSaved;
    }

    @Override
    public List<CinemaRoom> getAllRooms() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public CinemaRoom getRoomById(Long id) {
        return cinemaRoomRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Room not found"));
    }
}

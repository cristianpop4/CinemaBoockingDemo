package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.entity.Screening;

import java.util.List;

public interface ScreeningService {
    Screening createScreening(ScreeningRequestDto screening);
    List<Screening> getAllScreenings();
    Screening getScreeningById(Long id);
    List<Screening> getScreeningsByMovieId(Long id);
    List<Screening> getScreeningsByRoomId(Long id);
    List<Screening> getCurrentScreenings();
    Screening updateScreening(Long id, Screening screening);
    void deleteScreeningById(Long id);
}

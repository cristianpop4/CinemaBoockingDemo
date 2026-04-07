package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.entity.Screening;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningService {
    Screening createScreening(ScreeningRequestDto screening);
    List<Screening> getAllScreenings();
    Screening getScreeningById(Long id);
    List<Screening> getScreeningsByMovieId(Long id);
    List<Screening> getScreeningsByRoomId(Long id);
    List<Screening> getScreeningByPeriod(LocalDate start, LocalDate end);
    List<Screening> getScreeningByPeriodQuery(LocalDate start, LocalDate end);
    Screening updateScreening(Long id, ScreeningRequestDto dto);
    void deleteScreeningById(Long id);
}

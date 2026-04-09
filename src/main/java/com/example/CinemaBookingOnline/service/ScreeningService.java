package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.dto.ScreeningResponseDto;
import com.example.CinemaBookingOnline.model.entity.Screening;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningService {
    ScreeningResponseDto createScreening(ScreeningRequestDto screening);
    List<ScreeningResponseDto> getAllScreenings();
    ScreeningResponseDto getScreeningById(Long id);
    List<ScreeningResponseDto> getScreeningsByMovieId(Long id);
    List<ScreeningResponseDto> getScreeningsByRoomId(Long id);
    List<ScreeningResponseDto> getScreeningByPeriod(LocalDate start, LocalDate end);
    List<ScreeningResponseDto> getScreeningByPeriodQuery(LocalDate start, LocalDate end);
    ScreeningResponseDto updateScreening(Long id, ScreeningRequestDto dto);
    void deleteScreeningById(Long id);

    default ScreeningResponseDto toDto(Screening screening){
        return new ScreeningResponseDto(
                screening.getId(),
                screening.getMovie().getTitle(),
                screening.getCinemaRoom().getName(),
                screening.getPrice(),
                screening.getStartTime()
        );
    }
}

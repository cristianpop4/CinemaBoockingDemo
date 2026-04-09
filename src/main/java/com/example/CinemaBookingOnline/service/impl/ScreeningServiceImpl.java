package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.dto.ScreeningResponseDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import com.example.CinemaBookingOnline.model.entity.Movie;
import com.example.CinemaBookingOnline.model.entity.Screening;
import com.example.CinemaBookingOnline.repository.CinemaRoomRepository;
import com.example.CinemaBookingOnline.repository.MovieRepository;
import com.example.CinemaBookingOnline.repository.ScreeningRepository;
import com.example.CinemaBookingOnline.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningServiceImpl implements ScreeningService {
    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final CinemaRoomRepository cinemaRoomRepository;

    @Override
    public ScreeningResponseDto createScreening(ScreeningRequestDto dto) {
        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Movie not found " + dto.movieId()));

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(dto.roomId())
                .orElseThrow(()-> new RuntimeException("Room not found: " + dto.roomId()));

        Screening screening = new Screening();

        screening.setMovie(movie);
        screening.setCinemaRoom(cinemaRoom);
        screening.setPrice(dto.price());
        screening.setStartTime(LocalDate.now());

        return toDto(screeningRepository.save(screening));
    }

    @Override
    public List<ScreeningResponseDto> getAllScreenings() {
        return screeningRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ScreeningResponseDto getScreeningById(Long id) {
        return toDto(screeningRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Screening not found")));
    }

    @Override
    public List<ScreeningResponseDto> getScreeningsByMovieId(Long id) {
        return screeningRepository.findByMovieId(id)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<ScreeningResponseDto> getScreeningsByRoomId(Long id) {
        return screeningRepository.findByCinemaRoomId(id)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<ScreeningResponseDto> getScreeningByPeriod(LocalDate start, LocalDate end){
        return screeningRepository.findByStartTimeBetween(start, end)
                .stream()
                .map(this::toDto)
                .toList();
    }
    @Override
    public List<ScreeningResponseDto> getScreeningByPeriodQuery(LocalDate start, LocalDate end){
        return screeningRepository.getScreeningByPeriod(start, end)
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public ScreeningResponseDto updateScreening(Long id, ScreeningRequestDto dto) {
        Screening screening = screeningRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Screening not found"));

        screening.setMovie(movieRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Movie not found"))
        );
        screening.setCinemaRoom(cinemaRoomRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Room not found"))
        );

        screening.setPrice(dto.price());
        return toDto(screeningRepository.save(screening));
    }

    @Override
    public void deleteScreeningById(Long id) {
        Screening screening = screeningRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Screening not found"));

        screeningRepository.delete(screening);
    }
}

package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import com.example.CinemaBookingOnline.model.entity.Movie;
import com.example.CinemaBookingOnline.model.entity.Screening;
import com.example.CinemaBookingOnline.repository.CinemaRoomRepository;
import com.example.CinemaBookingOnline.repository.MovieRepository;
import com.example.CinemaBookingOnline.repository.ScreeningRepository;
import com.example.CinemaBookingOnline.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningServiceImpl implements ScreeningService {
    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final CinemaRoomRepository cinemaRoomRepository;

    @Override
    public Screening createScreening(ScreeningRequestDto dto) {
        Movie movie = movieRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Movie not found " + dto.movieId()));

        CinemaRoom cinemaRoom = cinemaRoomRepository.findById(dto.roomId())
                .orElseThrow(()-> new RuntimeException("Room not found: " + dto.roomId()));

        Screening screening = new Screening();

        screening.setMovie(movie);
        screening.setCinemaRoom(cinemaRoom);
        screening.setPrice(dto.price());
        screening.setStartTime(LocalDateTime.now());

        return screeningRepository.save(screening);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return List.of();
    }

    @Override
    public Screening getScreeningById(Long id) {
        return null;
    }

    @Override
    public List<Screening> getScreeningsByMovieId(Long id) {
        return List.of();
    }

    @Override
    public List<Screening> getScreeningsByRoomId(Long id) {
        return List.of();
    }

    @Override
    public List<Screening> getCurrentScreenings() {
        return List.of();
    }

    @Override
    public Screening updateScreening(Long id, Screening screening) {
        return null;
    }

    @Override
    public void deleteScreeningById(Long id) {

    }
}

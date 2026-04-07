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

import java.time.LocalDate;
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
        screening.setStartTime(LocalDate.now());

        return screeningRepository.save(screening);
    }

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Long id) {
        return screeningRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Screening not found"));
    }

    @Override
    public List<Screening> getScreeningsByMovieId(Long id) {
        return screeningRepository.findByMovieId(id);
    }

    @Override
    public List<Screening> getScreeningsByRoomId(Long id) {
        return screeningRepository.findByCinemaRoomId(id);
    }

    @Override
    public List<Screening> getScreeningByPeriod(LocalDate start, LocalDate end){
        return screeningRepository.findByStartTimeBetween(start, end);
    }
    @Override
    public List<Screening> getScreeningByPeriodQuery(LocalDate start, LocalDate end){
        return screeningRepository.getScreeningByPeriod(start, end);
    }

    @Override
    public Screening updateScreening(Long id, ScreeningRequestDto dto) {
        Screening screening = getScreeningById(id);

        screening.setMovie(movieRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Movie not found"))
        );
        screening.setCinemaRoom(cinemaRoomRepository.findById(dto.movieId())
                .orElseThrow(()-> new RuntimeException("Room not found"))
        );

        screening.setPrice(dto.price());
        return screeningRepository.save(screening);
    }

    @Override
    public void deleteScreeningById(Long id) {
        Screening screening = getScreeningById(id);

        screeningRepository.delete(screening);
    }
}

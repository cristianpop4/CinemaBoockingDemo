package com.example.CinemaBookingOnline.service.impl;

import com.example.CinemaBookingOnline.model.dto.MovieRequestDto;
import com.example.CinemaBookingOnline.model.dto.MovieResponseDto;
import com.example.CinemaBookingOnline.model.entity.Movie;
import com.example.CinemaBookingOnline.repository.MovieRepository;
import com.example.CinemaBookingOnline.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieResponseDto createMovie(MovieRequestDto dto) {
        Movie movie = new Movie(
                null,
                dto.title(),
                dto.rating(),
                dto.releaseYear()
        );

        return toDto(movieRepository.save(movie));
    }

    @Override
    public List<MovieResponseDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public MovieResponseDto getMovieById(Long id) {
        return toDto(movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie with if: " + id + " notFound"))
        );
    }

    @Override
    public MovieResponseDto updateMovie(Long id, MovieRequestDto dto) {
        Movie movieFound = movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie not found"));

        movieFound.setTitle(dto.title());
        movieFound.setRating(dto.rating());
        movieFound.setReleaseYear(dto.releaseYear());

        return toDto(movieRepository.save(movieFound));
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}

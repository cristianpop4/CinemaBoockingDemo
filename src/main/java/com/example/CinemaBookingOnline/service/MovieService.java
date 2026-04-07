package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.dto.MovieRequestDto;
import com.example.CinemaBookingOnline.model.dto.MovieResponseDto;
import com.example.CinemaBookingOnline.model.entity.Movie;

import java.util.List;

public interface MovieService {
    MovieResponseDto createMovie(MovieRequestDto movie);
    List<MovieResponseDto> getAllMovies();
    MovieResponseDto getMovieById(Long id);
    MovieResponseDto updateMovie(Long id, MovieRequestDto movie);
    void deleteMovieById(Long id);

    default MovieResponseDto toDto(Movie movie){
        return new MovieResponseDto(
                movie.getId(),
                movie.getTitle(),
                movie.getRating(),
                movie.getReleaseYear()
        );
    }
}

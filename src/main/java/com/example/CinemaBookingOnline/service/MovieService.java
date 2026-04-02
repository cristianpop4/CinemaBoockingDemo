package com.example.CinemaBookingOnline.service;

import com.example.CinemaBookingOnline.model.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovieById(Long id);
}

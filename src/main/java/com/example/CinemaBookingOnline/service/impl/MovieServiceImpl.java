package com.example.CinemaBookingOnline.service.impl;

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
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie with if: " + id + " notFound"));
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie movieFound = movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie not found"));

        movieFound.setTitle(movie.getTitle());
        movieFound.setRating(movie.getRating());
        movieFound.setReleaseYear(movie.getReleaseYear());

        return movieRepository.save(movieFound);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }
}

package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.entity.Movie;
import com.example.CinemaBookingOnline.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public Movie getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PutMapping("{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}

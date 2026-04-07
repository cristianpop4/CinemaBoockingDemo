package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.dto.MovieRequestDto;
import com.example.CinemaBookingOnline.model.dto.MovieResponseDto;
import com.example.CinemaBookingOnline.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @Operation(summary = "Save a movie in DB")
    @PostMapping
    public MovieResponseDto createMovie(@RequestBody MovieRequestDto dto){
        return movieService.createMovie(dto);
    }

    @Operation(summary = "Get all movies from DB")
    @GetMapping
    public List<MovieResponseDto> getAllMovies(){
        return movieService.getAllMovies();
    }

    @Operation(summary = "Get movie by id")
    @GetMapping("{id}")
    public MovieResponseDto getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @Operation(summary = "Update movie")
    @PutMapping("{id}")
    public MovieResponseDto updateMovie(@PathVariable Long id, @RequestBody MovieRequestDto movie){
        return movieService.updateMovie(id, movie);
    }

    @Operation(summary = "Delete movie")
    @DeleteMapping("{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}

package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.entity.Screening;
import com.example.CinemaBookingOnline.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;

    @PostMapping
    public Screening createScreening(@RequestBody ScreeningRequestDto dto){
        return screeningService.createScreening(dto);
    }

    @GetMapping
    public List<Screening> getAllScreenings(){
        return screeningService.getAllScreenings();
    }

    @GetMapping("/id/{id}")
    public Screening getScreeningById(@PathVariable Long id){
        return screeningService.getScreeningById(id);
    }

    @GetMapping("/movie/{movieId}")
    public List<Screening> getScreeningByMovieId(@PathVariable Long movieId){
        return screeningService.getScreeningsByMovieId(movieId);
    }

    @GetMapping("/room/{roomId}")
    public List<Screening> getScreeningByRoomId(@PathVariable Long roomId){
        return screeningService.getScreeningsByRoomId(roomId);
    }

    @GetMapping("/period")
    public List<Screening> getScreeningByPeriod(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return screeningService.getScreeningByPeriod(start, end);
    }

    @GetMapping("/period/query")
    public List<Screening> getScreeningByPeriodQuery(@RequestParam LocalDate start, @RequestParam LocalDate end){
        return screeningService.getScreeningByPeriodQuery(start, end);
    }

    @PutMapping("/{id}")
    public Screening updateScreening(@PathVariable Long id, @RequestBody ScreeningRequestDto dto){
        return screeningService.updateScreening(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteScreeningById(@PathVariable Long id){
        screeningService.deleteScreeningById(id);
    }

}

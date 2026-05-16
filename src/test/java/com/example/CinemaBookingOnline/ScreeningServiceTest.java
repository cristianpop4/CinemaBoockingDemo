package com.example.CinemaBookingOnline;

import com.example.CinemaBookingOnline.model.dto.ScreeningRequestDto;
import com.example.CinemaBookingOnline.model.dto.ScreeningResponseDto;
import com.example.CinemaBookingOnline.model.entity.CinemaRoom;
import com.example.CinemaBookingOnline.model.entity.Movie;
import com.example.CinemaBookingOnline.model.entity.Screening;
import com.example.CinemaBookingOnline.repository.CinemaRoomRepository;
import com.example.CinemaBookingOnline.repository.MovieRepository;
import com.example.CinemaBookingOnline.repository.ScreeningRepository;
import com.example.CinemaBookingOnline.service.impl.ScreeningServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScreeningServiceTest {
    @Mock
    private MovieRepository movieRepository;
    @Mock
    private ScreeningRepository screeningRepository;
    @Mock
    private CinemaRoomRepository cinemaRoomRepository;

    @InjectMocks
    private ScreeningServiceImpl screeningService;

    @Test
    void createScreening_success() {
        //given
        ScreeningRequestDto requestDto = new ScreeningRequestDto(1L, 1L, 20.0);

        Movie movie = new Movie();
        movie.setId(1L);

        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setId(1L);

        Screening screening = new Screening();
        screening.setId(2L);
        screening.setMovie(movie);
        screening.setCinemaRoom(cinemaRoom);
        screening.setPrice(20.0);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
        when(cinemaRoomRepository.findById(1L)).thenReturn(Optional.of(cinemaRoom));
        when(screeningRepository.save(any(Screening.class))).thenReturn(screening);

        //when
        ScreeningResponseDto responseDto = screeningService.createScreening(requestDto);

        //then
        assertNotNull(responseDto);
        assertEquals(2L, responseDto.id());
        assertEquals(20.0, responseDto.price());

        verify(movieRepository).findById(1L);
        verify(cinemaRoomRepository).findById(1L);
        verify(screeningRepository).save(any(Screening.class));
    }

    @Test
    void createScreening_failed_movieNotFound(){
        ScreeningRequestDto requestDto = new ScreeningRequestDto(1L, 2L, 50.0);

        when(movieRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class, ()-> screeningService.createScreening(requestDto));

        verify(movieRepository).findById(1L);
        verifyNoInteractions(cinemaRoomRepository);
        verifyNoInteractions(screeningRepository);
    }

    @Test
    void getAllScreenings_success(){
        Screening screening1 = new Screening();
        screening1.setId(1L);
        screening1.setMovie(new Movie());
        screening1.setCinemaRoom(new CinemaRoom());

        Screening screening2 = new Screening();
        screening2.setId(2L);
        screening2.setMovie(new Movie());
        screening2.setCinemaRoom(new CinemaRoom());

        when(screeningRepository.findAll()).thenReturn(List.of(screening1, screening2));

        List<ScreeningResponseDto> responseDtos = screeningService.getAllScreenings();

        assertEquals(2, responseDtos.size());

        verify(screeningRepository).findAll();
    }


}

package com.example.CinemaBookingOnline.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cinema_rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer colsCount;
    private Integer rowsCount;
    private String name;
}

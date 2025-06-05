package com.api.cinema.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Room room;
    private String seatNumber; // e.g., "A1", "B2"
    private boolean isAvailable; // true if the seat is available for booking
}

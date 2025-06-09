package com.api.cinema.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private int capacity;
    private RoomType roomType;
    private int numberOfRows;
    private int numberOfColumns;
    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @PostPersist
    private void generateSeats() {
        for (int row = 1; row <= numberOfRows; row++) {
            for (int col = 1; col <= numberOfColumns; col++) {
                Seat seat = new Seat();
                seat.setRoom(this);
                seat.setSeatNumber(String.format("%c%d", 'A' + (row - 1), col));
                seat.setAvailable(true);
                seats.add(seat);
            }
        }
    }
}

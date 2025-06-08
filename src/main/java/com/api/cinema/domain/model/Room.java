package com.api.cinema.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @OneToMany(mappedBy = "room")
    private List<Seat> seats;
}

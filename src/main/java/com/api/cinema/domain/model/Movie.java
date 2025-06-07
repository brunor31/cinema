package com.api.cinema.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Lob
    private String description;
    private AudioType audioType;
    private int duration;
    private int classification;
    private String genre;
}

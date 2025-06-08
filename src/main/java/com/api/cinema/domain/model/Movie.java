package com.api.cinema.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String title;
    @Lob
    private String description;
    private AudioType audioType;
    private int duration;
    private int classification;
    private String genre;
    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;
}

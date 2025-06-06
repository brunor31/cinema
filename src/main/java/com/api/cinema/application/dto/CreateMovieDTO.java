package com.api.cinema.application.dto;

import com.api.cinema.domain.model.AudioType;

public record CreateMovieDTO(String title,
                             String description,
                             AudioType audioType,
                             int duration,
                             int classification,
                             String genre) {
}

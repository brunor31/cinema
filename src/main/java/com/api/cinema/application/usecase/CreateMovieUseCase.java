package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.CreateMovieDTO;

public interface CreateMovieUseCase {
    void create(CreateMovieDTO createMovieDTO);
}

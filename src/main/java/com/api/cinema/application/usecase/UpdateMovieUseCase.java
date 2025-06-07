package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.CreateMovieDTO;
import com.api.cinema.application.dto.MovieDTO;

public interface UpdateMovieUseCase {
    MovieDTO update(long id, CreateMovieDTO movieDTO);
}

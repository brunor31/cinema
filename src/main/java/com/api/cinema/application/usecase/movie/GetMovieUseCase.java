package com.api.cinema.application.usecase.movie;

import com.api.cinema.application.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface GetMovieUseCase {
    List<MovieDTO> getAll();
    Optional<MovieDTO> get(long id);
}

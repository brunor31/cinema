package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.MovieDTO;

public interface CreateMovieUseCase {

    void execute(MovieDTO movieDTO);
}

package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.dto.SessionSummaryDTO;

import java.util.List;

public interface GetMovieUseCase {
    MovieDTO get(long id);
    List<MovieDTO> getAll();
    List<SessionSummaryDTO> getAllSession(long id);
}

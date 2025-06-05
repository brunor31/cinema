package com.api.cinema.application.service;

import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.usecase.CreateMovieUseCase;
import com.api.cinema.domain.model.Movie;
import com.api.cinema.infrastructure.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements CreateMovieUseCase {

    @Autowired
    private MovieRepository movieRepository;
    private ObjectMapper objectMapper;

    @Override
    public void execute(MovieDTO movieDTO) {
        this.objectMapper = new ObjectMapper();
        Movie movie = this.objectMapper.convertValue(movieDTO, Movie.class);
        this.movieRepository.save(movie);
    }
}

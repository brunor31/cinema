package com.api.cinema.application.service;

import com.api.cinema.application.dto.CreateMovieDTO;
import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.dto.SessionSummaryDTO;
import com.api.cinema.application.usecase.CreateMovieUseCase;
import com.api.cinema.application.usecase.DeleteMovieUseCase;
import com.api.cinema.application.usecase.GetMovieUseCase;
import com.api.cinema.application.usecase.UpdateMovieUseCase;
import com.api.cinema.domain.model.Movie;
import com.api.cinema.domain.repository.MovieRepository;
import com.api.cinema.domain.repository.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService implements CreateMovieUseCase, GetMovieUseCase, UpdateMovieUseCase, DeleteMovieUseCase {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void create(CreateMovieDTO createMovieDTO) {
        Movie movie = this.objectMapper.convertValue(createMovieDTO, Movie.class);
        this.movieRepository.save(movie);
    }

    @Override
    public void delete(long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        this.movieRepository.delete(movie);
    }

    @Override
    public MovieDTO get(long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        return this.objectMapper.convertValue(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> getAll() {
        return this.movieRepository.findAll().stream()
                .map(movie -> this.objectMapper.convertValue(movie, MovieDTO.class))
                .toList();
    }

    public List<SessionSummaryDTO> getAllSession(long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        LocalDateTime now = LocalDateTime.now();
        return this.sessionRepository.findByMovieAndStartTimeAfterOrderByStartTime(movie, now).stream()
                .map(session -> this.objectMapper.convertValue(session, SessionSummaryDTO.class))
                .toList();
    }

    @Override
    public MovieDTO update(long id, CreateMovieDTO createMovieDTO) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        BeanUtils.copyProperties(createMovieDTO, movie, "id");
        Movie updatedMovie = this.movieRepository.save(movie);
        return this.objectMapper.convertValue(updatedMovie, MovieDTO.class);
    }
}

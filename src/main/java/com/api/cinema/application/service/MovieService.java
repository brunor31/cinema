package com.api.cinema.application.service;

import com.api.cinema.application.dto.CreateMovieDTO;
import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.usecase.movie.CreateMovieUseCase;
import com.api.cinema.application.usecase.movie.DeleteMovieUseCase;
import com.api.cinema.application.usecase.movie.GetMovieUseCase;
import com.api.cinema.application.usecase.movie.UpdateMovieUseCase;
import com.api.cinema.domain.model.Movie;
import com.api.cinema.infrastructure.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements CreateMovieUseCase, GetMovieUseCase, UpdateMovieUseCase, DeleteMovieUseCase {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(CreateMovieDTO createMovieDTO) {
        Movie movie = this.objectMapper.convertValue(createMovieDTO, Movie.class);
        this.movieRepository.save(movie);
    }

    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = this.movieRepository.findAll();
        return movies.stream()
                .map(movie -> this.objectMapper.convertValue(movie, MovieDTO.class))
                .toList();
    }

    @Override
    public Optional<MovieDTO> get(long id) {
        Optional<Movie> movie = this.movieRepository.findById(id);
        return movie.map(m -> this.objectMapper.convertValue(m, MovieDTO.class));
    }

    @Override
    public MovieDTO update(long id, CreateMovieDTO createMovieDTO) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível localizar o id informado"));

        movie.setTitle(createMovieDTO.title());
        movie.setDescription(createMovieDTO.description());
        movie.setAudioType(createMovieDTO.audioType());
        movie.setDuration(createMovieDTO.duration());
        movie.setClassification(createMovieDTO.classification());
        movie.setGenre(createMovieDTO.genre());

        Movie updatedMovie = this.movieRepository.save(movie);
        return this.objectMapper.convertValue(updatedMovie, MovieDTO.class);
    }

    @Override
    public void delete(long id) {
        Movie movie = this.movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível localizar o id informado"));
        this.movieRepository.delete(movie);
    }

}

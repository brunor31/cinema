package com.api.cinema.adapter.controller;

import com.api.cinema.application.dto.CreateMovieDTO;
import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.dto.SessionDTO;
import com.api.cinema.application.dto.SessionSummaryDTO;
import com.api.cinema.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody CreateMovieDTO createMovieDTO) {
        this.movieService.create(createMovieDTO);
    }

    @DeleteMapping("/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable long movieId) {
        this.movieService.delete(movieId);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable long movieId) {
        MovieDTO movieDTO = this.movieService.get(movieId);
        return ResponseEntity.ok(movieDTO);
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getMovies() {
        List<MovieDTO> movies = this.movieService.getAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{movieId}/sessions")
    public ResponseEntity<List<SessionSummaryDTO>> getSessions(@PathVariable long movieId) {
        List<SessionSummaryDTO> sessionSummaryDTOS = this.movieService.getAllSession(movieId);
        return ResponseEntity.ok(sessionSummaryDTOS);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable long movieId, @RequestBody CreateMovieDTO createMovieDTO) {
        MovieDTO movieDTO = this.movieService.update(movieId, createMovieDTO);
        return ResponseEntity.ok(movieDTO);
    }
}

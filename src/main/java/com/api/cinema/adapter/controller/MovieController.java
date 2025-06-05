package com.api.cinema.adapter.controller;

import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieDTO movieDTO) {
        String teste = "teste";
        movieService.execute(movieDTO);
    }
}

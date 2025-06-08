package com.api.cinema.application.service;

import com.api.cinema.application.dto.CreateSessionDTO;
import com.api.cinema.application.dto.MovieDTO;
import com.api.cinema.application.dto.RoomDTO;
import com.api.cinema.application.dto.SessionDTO;
import com.api.cinema.application.usecase.CreateSessionUseCase;
import com.api.cinema.application.usecase.DeleteSessionUseCase;
import com.api.cinema.application.usecase.GetSessionUseCase;
import com.api.cinema.application.usecase.UpdateSessionUseCase;
import com.api.cinema.domain.model.Movie;
import com.api.cinema.domain.model.Room;
import com.api.cinema.domain.model.Session;
import com.api.cinema.domain.repository.MovieRepository;
import com.api.cinema.domain.repository.RoomRepository;
import com.api.cinema.domain.repository.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService implements CreateSessionUseCase, GetSessionUseCase, UpdateSessionUseCase, DeleteSessionUseCase {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(CreateSessionDTO createSessionDTO) {
        Movie movie = this.movieRepository.findById(createSessionDTO.movieId()).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided movieId."));
        Room room = this.roomRepository.findById(createSessionDTO.roomId()).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided roomId."));
        Session session = new Session();
        session.setMovie(movie);
        session.setRoom(room);
        session.setStartTime(createSessionDTO.startTime());
        this.sessionRepository.save(session);
    }

    @Override
    public void delete(long id) {
        Session session = this.sessionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        this.sessionRepository.delete(session);
    }

    @Override
    public SessionDTO get(long id) {
        Session session = this.sessionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        return this.objectMapper.convertValue(session, SessionDTO.class);
    }

    @Override
    public List<SessionDTO> getAll() {
        return this.sessionRepository.findAll().stream()
                .map(session -> this.objectMapper.convertValue(session, SessionDTO.class))
                .toList();
    }

    @Override
    public SessionDTO update(long id, CreateSessionDTO createSessionDTO) {
        Session session = this.sessionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        Movie movie = this.movieRepository.findById(createSessionDTO.movieId()).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided movieId."));
        Room room = this.roomRepository.findById(createSessionDTO.roomId()).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided roomId."));
        session.setMovie(movie);
        session.setRoom(room);
        session.setStartTime(createSessionDTO.startTime());
        this.sessionRepository.save(session);
        return this.objectMapper.convertValue(session, SessionDTO.class);
    }
}

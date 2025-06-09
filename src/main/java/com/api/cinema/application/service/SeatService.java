package com.api.cinema.application.service;

import com.api.cinema.application.dto.SeatDTO;
import com.api.cinema.application.usecase.GetAvailableSeat;
import com.api.cinema.domain.model.Session;
import com.api.cinema.domain.repository.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService implements GetAvailableSeat {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<SeatDTO> getSeats(long sessionId) {
        Session session = this.sessionRepository.findById(sessionId).
                orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        return session.getRoom().getSeats().stream()
                .map(seat -> this.objectMapper.convertValue(seat, SeatDTO.class))
                .toList();
    }
}

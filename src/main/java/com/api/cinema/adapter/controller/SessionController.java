package com.api.cinema.adapter.controller;

import com.api.cinema.application.dto.CreateSessionDTO;
import com.api.cinema.application.dto.SeatDTO;
import com.api.cinema.application.dto.SessionDTO;
import com.api.cinema.application.service.SeatService;
import com.api.cinema.application.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private SeatService seatService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSession(@RequestBody CreateSessionDTO createSessionDTO) {
        this.sessionService.create(createSessionDTO);
    }

    @DeleteMapping("/{sessionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSession(@PathVariable long sessionId) {
        this.sessionService.delete(sessionId);
    }

    @GetMapping("/{sessionId}/seats")
    public ResponseEntity<List<SeatDTO>> getSeats(@PathVariable long sessionId) {
        List<SeatDTO> seatDTOS = this.seatService.getSeats(sessionId);
        return ResponseEntity.ok(seatDTOS);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> getSession(@PathVariable long sessionId) {
        SessionDTO sessionDTO = this.sessionService.get(sessionId);
        return ResponseEntity.ok(sessionDTO);
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> getSessions() {
        List<SessionDTO> sessionDTOS = this.sessionService.getAll();
        return ResponseEntity.ok(sessionDTOS);
    }

    @PutMapping("/{sessionID}")
    public ResponseEntity<SessionDTO> updateSession(
            @PathVariable long sessionId, @RequestBody CreateSessionDTO createSessionDTO) {
        SessionDTO sessionDTO = this.sessionService.update(sessionId, createSessionDTO);
        return ResponseEntity.ok(sessionDTO);
    }
}

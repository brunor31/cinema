package com.api.cinema.adapter.controller;

import com.api.cinema.application.dto.CreateRoomDTO;
import com.api.cinema.application.dto.RoomDTO;
import com.api.cinema.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
        this.roomService.create(createRoomDTO);
    }

    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable long roomId) {
        this.roomService.delete(roomId);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<RoomDTO> getRoom(@PathVariable long roomId) {
        RoomDTO roomDTO = this.roomService.get(roomId);
        return ResponseEntity.ok(roomDTO);
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getRooms() {
        List<RoomDTO> roomDTOS = this.roomService.getAll();
        return ResponseEntity.ok(roomDTOS);
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable long roomId, @RequestBody CreateRoomDTO createRoomDTO) {
        RoomDTO roomDTO = this.roomService.update(roomId, createRoomDTO);
        return ResponseEntity.ok(roomDTO);
    }
}

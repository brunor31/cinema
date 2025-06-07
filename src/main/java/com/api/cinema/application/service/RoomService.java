package com.api.cinema.application.service;

import com.api.cinema.application.dto.CreateRoomDTO;
import com.api.cinema.application.dto.RoomDTO;
import com.api.cinema.application.usecase.CreateRoomUseCase;
import com.api.cinema.application.usecase.DeleteRoomUseCase;
import com.api.cinema.application.usecase.GetRoomUseCase;
import com.api.cinema.application.usecase.UpdateRoomUseCase;
import com.api.cinema.domain.model.Room;
import com.api.cinema.infrastructure.repository.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements CreateRoomUseCase, GetRoomUseCase, UpdateRoomUseCase, DeleteRoomUseCase {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void create(CreateRoomDTO createRoomDTO) {
        Room room = this.objectMapper.convertValue(createRoomDTO, Room.class);
        this.roomRepository.save(room);
    }

    @Override
    public void delete(long id) {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        this.roomRepository.delete(room);
    }

    @Override
    public RoomDTO get(long id) {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));
        return this.objectMapper.convertValue(room, RoomDTO.class);
    }

    @Override
    public List<RoomDTO> getAll() {
        return this.roomRepository.findAll().stream()
                .map(room -> this.objectMapper.convertValue(room, RoomDTO.class))
                .toList();
    }

    @Override
    public RoomDTO update(long id, CreateRoomDTO createRoomDTO) {
        Room room = this.roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("It was not possible to locate the provided id."));

        room.setName(createRoomDTO.name());
        room.setCapacity(createRoomDTO.capacity());
        room.setRoomType(createRoomDTO.roomType());
        room.setNumberOfRows(createRoomDTO.numberOfRows());
        room.setNumberOfColumns(createRoomDTO.numberOfColumns());
        Room updatedRoom = this.roomRepository.save(room);
        return this.objectMapper.convertValue(updatedRoom, RoomDTO.class);
    }
}

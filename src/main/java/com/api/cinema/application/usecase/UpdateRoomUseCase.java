package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.CreateRoomDTO;
import com.api.cinema.application.dto.RoomDTO;

public interface UpdateRoomUseCase {
    RoomDTO update(long id, CreateRoomDTO createRoomDTO);
}

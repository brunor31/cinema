package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.RoomDTO;

import java.util.List;

public interface GetRoomUseCase {
    RoomDTO get(long id);
    List<RoomDTO> getAll();
}

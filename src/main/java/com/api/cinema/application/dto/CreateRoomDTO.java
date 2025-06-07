package com.api.cinema.application.dto;

import com.api.cinema.domain.model.RoomType;

public record CreateRoomDTO(String name,
                            int capacity,
                            RoomType roomType,
                            int numberOfRows,
                            int numberOfColumns) {
}

package com.api.cinema.application.dto;

import com.api.cinema.domain.model.RoomType;

public record RoomDTO(long id,
                      String name,
                      int capacity,
                      RoomType roomType,
                      int numberOfRows,
                      int numberOfColumns) {
}

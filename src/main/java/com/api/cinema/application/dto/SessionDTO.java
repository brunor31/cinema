package com.api.cinema.application.dto;

import java.time.LocalDateTime;

public record SessionDTO(long id,
                         MovieDTO movieDTO,
                         RoomDTO roomDTO,
                         LocalDateTime startTime) {
}

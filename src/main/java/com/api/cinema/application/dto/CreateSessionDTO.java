package com.api.cinema.application.dto;

import java.time.LocalDateTime;

public record CreateSessionDTO(long movieId,
                               long roomId,
                               LocalDateTime startTime) {
}

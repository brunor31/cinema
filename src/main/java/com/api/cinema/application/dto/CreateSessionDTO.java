package com.api.cinema.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record CreateSessionDTO(long movieId,
                               long roomId,
                               @Schema(description = "Session start date and time", example = "00-00-0000 00:00:00")
                               @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime startTime) {
}

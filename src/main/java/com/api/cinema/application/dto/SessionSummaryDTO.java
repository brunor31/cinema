package com.api.cinema.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SessionSummaryDTO(long id,
                                RoomDTO room,
                                @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
                                LocalDateTime startTime) {
}

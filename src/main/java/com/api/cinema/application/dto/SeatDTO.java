package com.api.cinema.application.dto;

public record SeatDTO(long id,
                      String seatNumber,
                      boolean isAvailable) {
}

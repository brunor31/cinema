package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.SeatDTO;

import java.util.List;

public interface GetAvailableSeat {
    List<SeatDTO> getSeats(long sessionId);
}

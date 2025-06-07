package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.CreateSessionDTO;

public interface CreateSessionUseCase {
    void create(CreateSessionDTO createSessionDTO);
}

package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.SessionDTO;

import java.util.List;

public interface GetSessionUseCase {
    SessionDTO get(long id);
    List<SessionDTO> getAll();
}

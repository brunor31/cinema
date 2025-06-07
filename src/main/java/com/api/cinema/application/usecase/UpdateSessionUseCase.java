package com.api.cinema.application.usecase;

import com.api.cinema.application.dto.CreateSessionDTO;
import com.api.cinema.application.dto.SessionDTO;

public interface UpdateSessionUseCase {
    SessionDTO update(long id, CreateSessionDTO createSessionDTO);
}

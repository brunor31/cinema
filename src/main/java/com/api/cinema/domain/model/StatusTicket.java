package com.api.cinema.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum StatusTicket {

    BOOKED(0),
    CANCELLED(1),
    PAID(2);

    private final int value;

    StatusTicket(int value) {
        this.value = value;
    }

    public StatusTicket fromValue(int value) {
        for (StatusTicket statusTicket : StatusTicket.values()) {
            if (value == statusTicket.getValue()) {
                return statusTicket;
            }
        }
        throw new IllegalArgumentException("Unknown StatusTicket value: " + value);
    }
}

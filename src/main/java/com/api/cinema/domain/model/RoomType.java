package com.api.cinema.domain.model;

import lombok.Getter;

@Getter
public enum RoomType {
    TWO_D(0),
    THREE_D(1),
    IMAX(2);

    private final int value;

    RoomType(int value) {
        this.value = value;
    }

    public static RoomType fromValue(int value) {
        for (RoomType type : RoomType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown RoomType value: " + value);
    }
}

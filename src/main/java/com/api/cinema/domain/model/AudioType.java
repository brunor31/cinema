package com.api.cinema.domain.model;

import lombok.Getter;

@Getter
public enum AudioType {

    DUBBED(0),
    SUBTITLED(1);

    private final int value;

    AudioType(int value) {
        this.value = value;
    }

    public static AudioType fromValue(int value) {
        for (AudioType audioType : AudioType.values()) {
            if(value == audioType.getValue()) {
                return audioType;
            }
        }
        throw new IllegalArgumentException("Unknown AudioType value: " + value);
    }
}

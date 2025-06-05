package com.api.cinema.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password; // Store hashed passwords in production
    private String role; // e.g., "USER", "ADMIN"
    private String phoneNumber; // Optional, for contact purposes
}

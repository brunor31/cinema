package com.api.cinema.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Session session; // The session for which the ticket is booked
    @ManyToOne
    private Seat seat; // The seat that is booked
    @ManyToOne
    private User user; // Name of the customer who booked the ticket
    private double price; // Price of the ticket
    private String status; // e.g., "booked", "cancelled", "paid"
}

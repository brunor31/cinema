package com.api.cinema.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @ManyToOne
    private Session session; // The session for which the ticket is booked
    @ManyToOne
    private Seat seat; // The seat that is booked
    @ManyToOne
    private User user; // Name of the customer who booked the ticket
    private BigDecimal price; // Price of the ticket
    private StatusTicket status; // e.g., "booked", "cancelled", "paid"
}

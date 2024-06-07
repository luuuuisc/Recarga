package com.example.recarga.entity;

import com.example.recarga.enume.StatusRecharge;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private StatusRecharge status;
    // Getters and setters

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @MapsId
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public Client getClient() {
        return client;
    }

    public StatusRecharge getStatus() {
        return status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Long getId() {
        return id;
    }
}

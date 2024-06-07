package com.example.recarga.entity;

import com.example.recarga.enume.StatusRecharge;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_recharge")
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private StatusRecharge status;
    // Getters and setters

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private BigDecimal amount;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(StatusRecharge status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

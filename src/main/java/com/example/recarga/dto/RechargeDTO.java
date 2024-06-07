package com.example.recarga.dto;

import com.example.recarga.enume.StatusRecharge;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RechargeDTO {

        private Long id;
        private Long clientId;
        private BigDecimal amount;
        private LocalDateTime dateTime;
        private StatusRecharge status;

    public StatusRecharge getStatus() {
        return status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getId() {
        return id;
    }

    public void setStatus(StatusRecharge status) {
        this.status = status;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

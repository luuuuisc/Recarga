package com.example.recarga.dto;

import com.example.recarga.entity.Payment;
import com.example.recarga.entity.PaymentMethod;

import java.math.BigDecimal;

public class PaymentDTO {
    private Long id;
    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    public PaymentDTO(Long id, String paymentMethod, BigDecimal amount) {
        this.id = id;
        this.paymentMethod = PaymentMethod.valueOf(paymentMethod);
        this.amount = amount;
    }

    public PaymentDTO(Payment payment) {
        id = payment.getId();
        paymentMethod = payment.getPaymentMethod();
        amount = payment.getAmount();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

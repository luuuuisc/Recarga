package com.example.recarga.service;

import com.example.recarga.dto.PaymentDTO;
import com.example.recarga.entity.Payment;
import com.example.recarga.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public Payment saveOrUpdatePayment(Payment payment) {

        return paymentRepository.save(payment);
    }


    public Optional<Payment> findPaymentById(Long id) {

        return paymentRepository.findById(id);
    }


    public Page<PaymentDTO> findAllPayments(Pageable pageable) {
        Page<Payment> result =  paymentRepository.findAll(pageable);
        return result.map(x -> new PaymentDTO(x));
    }



    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
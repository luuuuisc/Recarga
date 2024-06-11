package com.example.recarga.service;

import com.example.recarga.dto.RechargeDTO;
import com.example.recarga.entity.Recharge;
import com.example.recarga.enume.StatusRecharge;
import com.example.recarga.repository.RechargeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void scheduleRecharge(RechargeDTO recharge) {
        rabbitTemplate.convertAndSend("rechargeExchange", "recharge.request", recharge);
    }

    public RechargeDTO saveRecharge(RechargeDTO dto) {
        Recharge recharge = new Recharge();
        // Directly setting values from DTO
        recharge.setAmount(dto.getAmount());
        recharge.setDateTime(dto.getDateTime());
        recharge.setStatus(dto.getStatus());
        // Assume client is set elsewhere or is not required for this example

        recharge = rechargeRepository.save(recharge);

        // Immediately converting back to DTO for return
        dto.setId(recharge.getId());
        return dto;
    }

    public RechargeDTO findById(Long id) {
        return rechargeRepository.findById(id)
                .map(recharge -> {
                    RechargeDTO dto = new RechargeDTO();
                    dto.setId(recharge.getId());
                    dto.setAmount(recharge.getAmount());
                    dto.setDateTime(recharge.getDateTime());
                    dto.setStatus(recharge.getStatus());
                    return dto;
                })
                .orElse(null);
    }

    public List<RechargeDTO> findAll() {
        return rechargeRepository.findAll().stream()
                .map(recharge -> {
                    RechargeDTO dto = new RechargeDTO();
                    dto.setId(recharge.getId());
                    dto.setAmount(recharge.getAmount());
                    dto.setDateTime(recharge.getDateTime());
                    dto.setStatus(recharge.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        rechargeRepository.deleteById(id);
    }
}


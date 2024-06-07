package com.example.recarga.controller;


import com.example.recarga.dto.RechargeDTO;
import com.example.recarga.entity.Recharge;
import com.example.recarga.enume.StatusRecharge;
import com.example.recarga.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @PostMapping
    public ResponseEntity<RechargeDTO> createRecharge(@RequestBody RechargeDTO rechargeDTO) {
        Recharge recharge = convertToEntity(rechargeDTO);
        recharge = rechargeService.saveRecharge(recharge);
        return ResponseEntity.ok(convertToDto(recharge));

    }

    private Recharge convertToEntity(RechargeDTO dto) {
        Recharge recharge = new Recharge();
        recharge.setId(dto.getId());
        recharge.setAmount(dto.getAmount());
        recharge.setDateTime(dto.getDateTime() == null ? LocalDateTime.now() : dto.getDateTime());
        recharge.setStatus((dto.getStatus()));
        return recharge;
    }

    private RechargeDTO convertToDto(Recharge recharge) {
        RechargeDTO dto = new RechargeDTO();
        dto.setId(recharge.getId());
        dto.setAmount(recharge.getAmount());
        dto.setDateTime(recharge.getDateTime());
        dto.setStatus(recharge.getStatus());
        dto.setClientId(recharge.getClient().getId());
        return dto;
    }

}


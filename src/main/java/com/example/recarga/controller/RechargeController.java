package com.example.recarga.controller;


import com.example.recarga.dto.RechargeDTO;
import com.example.recarga.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recharges")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @PostMapping
    public ResponseEntity<RechargeDTO> createRecharge(@RequestBody RechargeDTO rechargeDTO) {
        RechargeDTO savedRecharge = rechargeService.saveRecharge(rechargeDTO);
        return ResponseEntity.ok(savedRecharge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RechargeDTO> getRechargeById(@PathVariable Long id) {
        RechargeDTO rechargeDTO = rechargeService.findById(id);
        return rechargeDTO != null ? ResponseEntity.ok(rechargeDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<RechargeDTO>> getAllRecharges() {
        List<RechargeDTO> recharges = rechargeService.findAll();
        return ResponseEntity.ok(recharges);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecharge(@PathVariable Long id) {
        rechargeService.delete(id);
        return ResponseEntity.ok().build();
    }
}

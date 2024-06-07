package com.example.recarga.repository;

import com.example.recarga.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {

    List<Recharge> findByClientId(Long clientId);
}

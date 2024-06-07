package com.example.recarga.service;

import com.example.recarga.entity.Recharge;
import com.example.recarga.enume.StatusRecharge;
import com.example.recarga.repository.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    // Realizar uma nova recarga
    public Recharge saveRecharge(Recharge recharge) {

        return rechargeRepository.save(recharge);
    }

    // Buscar recargas por cliente
    public List<Recharge> findRechargesByClientId(Long clientId) {
        return rechargeRepository.findByClientId(clientId);
    }

    // Listar todas as recargas
    public List<Recharge> findAllRecharges() {
        return rechargeRepository.findAll();
    }

    // Buscar uma recarga pelo ID
    public Optional<Recharge> findRechargeById(Long id) {

        return rechargeRepository.findById(id);
    }

    // Atualizar o status de uma recarga
    public Recharge updateRechargeStatus(Long id, StatusRecharge newStatus) {
        Optional<Recharge> recharge = findRechargeById(id);
        if (recharge.isPresent()) {
            Recharge updatedRecharge = recharge.get();
            updatedRecharge.setStatus(newStatus);
            return saveRecharge(updatedRecharge);
        }
        return null; // Ou lançar uma exceção personalizada se preferir
    }


    public void deleteRecharge(Long id) {

        rechargeRepository.deleteById(id);
    }
}

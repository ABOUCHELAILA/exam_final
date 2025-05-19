package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    List<CreditProfessionnel> findByClientId(Long clientId);
}

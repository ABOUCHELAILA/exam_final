package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    List<CreditPersonnel> findByClientId(Long clientId);
}

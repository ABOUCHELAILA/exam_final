package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    List<CreditImmobilier> findByClientId(Long clientId);
}

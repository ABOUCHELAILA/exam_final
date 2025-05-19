package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}

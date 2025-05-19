package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
}

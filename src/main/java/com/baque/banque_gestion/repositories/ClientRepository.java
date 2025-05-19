package com.baque.banque_gestion.repositories;

import com.baque.banque_gestion.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

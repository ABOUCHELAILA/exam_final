package com.baque.banque_gestion.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnel extends Credit {

    private String motif; // Exemple : achat voiture, études, etc.
}

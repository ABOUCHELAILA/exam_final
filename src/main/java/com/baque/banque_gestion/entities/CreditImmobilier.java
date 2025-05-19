package com.baque.banque_gestion.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilier extends Credit {

    private String typeBien; // Appartement, Maison, Local Commercial
}

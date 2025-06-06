package com.baque.banque_gestion.dtos;

import com.baque.banque_gestion.entities.TypeRemboursement;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;
    private Long creditId;
}

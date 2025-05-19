package com.baque.banque_gestion.mappers;

import com.baque.banque_gestion.dtos.RemboursementDTO;
import com.baque.banque_gestion.entities.Remboursement;

public class RemboursementMapper {
    public static RemboursementDTO toDTO(Remboursement r) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(r.getId());
        dto.setDate(r.getDate());
        dto.setMontant(r.getMontant());
        dto.setType(r.getType());
        dto.setCreditId(r.getCredit().getId());
        return dto;
    }
}

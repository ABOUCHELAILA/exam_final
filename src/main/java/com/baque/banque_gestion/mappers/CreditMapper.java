package com.baque.banque_gestion.mappers;

import com.baque.banque_gestion.dtos.CreditDTO;
import com.baque.banque_gestion.entities.Credit;
import com.baque.banque_gestion.entities.Client;

public class CreditMapper {
    public static CreditDTO toDTO(Credit credit) {
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDuree(credit.getDuree());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient() != null ? credit.getClient().getId() : null);
        return dto;
    }

    public static Credit toEntity(CreditDTO dto, Client client) {
        Credit credit = new Credit() {
        }; // Attention : instanciation d'une classe abstraite → à remplacer selon le type de crédit réel
        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcceptation(dto.getDateAcceptation());
        credit.setMontant(dto.getMontant());
        credit.setDuree(dto.getDuree());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setClient(client);
        return credit;
    }
}

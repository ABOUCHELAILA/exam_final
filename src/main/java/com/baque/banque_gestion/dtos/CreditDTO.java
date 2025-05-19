package com.baque.banque_gestion.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private String statut;
    private LocalDate dateAcceptation;
    private double montant;
    private int duree;
    private double tauxInteret;
    private Long clientId;
}

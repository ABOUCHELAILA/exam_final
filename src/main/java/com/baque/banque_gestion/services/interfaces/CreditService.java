package com.baque.banque_gestion.services.interfaces;

import com.baque.banque_gestion.dtos.CreditDTO;

import java.util.List;

public interface CreditService {
    List<CreditDTO> getAllCredits();
    List<CreditDTO> getCreditsByClientId(Long clientId);
}

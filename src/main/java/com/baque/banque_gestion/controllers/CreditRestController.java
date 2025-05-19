package com.baque.banque_gestion.controllers;

import com.baque.banque_gestion.dtos.CreditDTO;
import com.baque.banque_gestion.services.interfaces.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des crédits
 */
@RestController
@RequestMapping("/api/credits")
@RequiredArgsConstructor
public class CreditRestController {

    private final CreditService creditService;

    /**
     * Récupérer tous les crédits
     */
    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits();
    }

    /**
     * Récupérer les crédits d'un client spécifique
     */
    @GetMapping("/client/{clientId}")
    public List<CreditDTO> getCreditsByClient(@PathVariable Long clientId) {
        return creditService.getCreditsByClientId(clientId);
    }
}

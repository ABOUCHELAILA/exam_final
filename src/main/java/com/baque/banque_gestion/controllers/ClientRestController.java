package com.baque.banque_gestion.controllers;

import com.baque.banque_gestion.dtos.ClientDTO;
import com.baque.banque_gestion.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des clients
 */
@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    /**
     * Récupérer la liste de tous les clients
     */
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * Récupérer un client spécifique par son ID
     */
    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    /**
     * Ajouter un nouveau client
     */
    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }
}

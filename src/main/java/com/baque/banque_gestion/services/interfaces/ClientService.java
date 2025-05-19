package com.baque.banque_gestion.services.interfaces;

import com.baque.banque_gestion.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
}

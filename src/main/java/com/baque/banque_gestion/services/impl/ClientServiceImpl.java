package com.baque.banque_gestion.services.impl;

import com.baque.banque_gestion.dtos.ClientDTO;
import com.baque.banque_gestion.entities.Client;
import com.baque.banque_gestion.mappers.ClientMapper;
import com.baque.banque_gestion.repositories.ClientRepository;
import com.baque.banque_gestion.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDTO)
                .orElse(null);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        return ClientMapper.toDTO(clientRepository.save(client));
    }
}

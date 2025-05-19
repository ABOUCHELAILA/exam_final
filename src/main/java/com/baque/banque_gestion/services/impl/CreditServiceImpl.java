package com.baque.banque_gestion.services.impl;

import com.baque.banque_gestion.dtos.CreditDTO;
import com.baque.banque_gestion.entities.Credit;
import com.baque.banque_gestion.mappers.CreditMapper;
import com.baque.banque_gestion.repositories.CreditImmobilierRepository;
import com.baque.banque_gestion.repositories.CreditPersonnelRepository;
import com.baque.banque_gestion.repositories.CreditProfessionnelRepository;
import com.baque.banque_gestion.services.interfaces.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditPersonnelRepository creditPersonnelRepo;
    private final CreditImmobilierRepository creditImmobilierRepo;
    private final CreditProfessionnelRepository creditProfessionnelRepo;

    @Override
    public List<CreditDTO> getAllCredits() {
        List<Credit> allCredits = new ArrayList<>();
        allCredits.addAll(creditPersonnelRepo.findAll());
        allCredits.addAll(creditImmobilierRepo.findAll());
        allCredits.addAll(creditProfessionnelRepo.findAll());

        return allCredits.stream()
                .map(CreditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> getCreditsByClientId(Long clientId) {
        List<Credit> credits = new ArrayList<>();
        credits.addAll(creditPersonnelRepo.findByClientId(clientId));
        credits.addAll(creditImmobilierRepo.findByClientId(clientId));
        credits.addAll(creditProfessionnelRepo.findByClientId(clientId));

        return credits.stream()
                .map(CreditMapper::toDTO)
                .collect(Collectors.toList());
    }
}

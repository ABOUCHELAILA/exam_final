package com.baque.banque_gestion;

import com.baque.banque_gestion.entities.*;
import com.baque.banque_gestion.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BanqueGestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueGestionApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(
			ClientRepository clientRepo,
			CreditPersonnelRepository creditPersonnelRepo,
			CreditImmobilierRepository creditImmobilierRepo,
			CreditProfessionnelRepository creditProfessionnelRepo,
			RemboursementRepository remboursementRepo
	) {
		return args -> {
			// Créer un client
			Client client = new Client();
			client.setNom("Ali");
			client.setEmail("ali@gmail.com");
			client = clientRepo.save(client);

			// Créer un crédit personnel
			CreditPersonnel cp = new CreditPersonnel();
			cp.setClient(client);
			cp.setDateDemande(LocalDate.now());
			cp.setStatut("En cours");
			cp.setMontant(10000);
			cp.setTauxInteret(3.5);
			cp.setDuree(24);
			cp.setMotif("Achat de voiture");
			cp = creditPersonnelRepo.save(cp);

			// Ajouter un remboursement
			Remboursement r = new Remboursement();
			r.setCredit(cp);
			r.setDate(LocalDate.now().plusMonths(1));
			r.setMontant(500);
			r.setType(TypeRemboursement.MENSUALITE);
			remboursementRepo.save(r);

			System.out.println("Données insérées avec succès !");
		};
	}
}

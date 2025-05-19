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

            // === Client 1 : Ali ===
            Client client1 = new Client(null, "Ali", "ali@gmail.com", null);
            client1 = clientRepo.save(client1);

            CreditPersonnel credit1 = new CreditPersonnel();
            credit1.setClient(client1);
            credit1.setDateDemande(LocalDate.now().minusDays(10));
            credit1.setStatut("Accepté");
            credit1.setDateAcceptation(LocalDate.now().minusDays(5));
            credit1.setMontant(12000);
            credit1.setTauxInteret(4.2);
            credit1.setDuree(36);
            credit1.setMotif("Études");
            credit1 = creditPersonnelRepo.save(credit1);

            Remboursement r1 = new Remboursement(null, LocalDate.now().minusDays(3), 500, TypeRemboursement.MENSUALITE, credit1);
            remboursementRepo.save(r1);


            // === Client 2 : Sara ===
            Client client2 = new Client(null, "Sara", "sara@gmail.com", null);
            client2 = clientRepo.save(client2);

            CreditImmobilier credit2 = new CreditImmobilier();
            credit2.setClient(client2);
            credit2.setDateDemande(LocalDate.now().minusMonths(2));
            credit2.setStatut("En cours");
            credit2.setMontant(200000);
            credit2.setTauxInteret(3.9);
            credit2.setDuree(240);
            credit2.setTypeBien("Maison");
            credit2 = creditImmobilierRepo.save(credit2);


            // === Client 3 : Yassine ===
            Client client3 = new Client(null, "Yassine", "yassine@gmail.com", null);
            client3 = clientRepo.save(client3);

            CreditProfessionnel credit3 = new CreditProfessionnel();
            credit3.setClient(client3);
            credit3.setDateDemande(LocalDate.now().minusWeeks(3));
            credit3.setStatut("Rejeté");
            credit3.setMontant(50000);
            credit3.setTauxInteret(5.0);
            credit3.setDuree(60);
            credit3.setMotif("Achat matériel");
            credit3.setRaisonSociale("Yassine AutoServices SARL");
            credit3 = creditProfessionnelRepo.save(credit3);


            // === Client 4 : Imane avec plusieurs crédits ===
            Client client4 = new Client(null, "Imane", "imane@gmail.com", null);
            client4 = clientRepo.save(client4);

            CreditPersonnel credit4a = new CreditPersonnel();
            credit4a.setClient(client4);
            credit4a.setDateDemande(LocalDate.now().minusDays(20));
            credit4a.setStatut("Accepté");
            credit4a.setDateAcceptation(LocalDate.now().minusDays(15));
            credit4a.setMontant(8000);
            credit4a.setDuree(18);
            credit4a.setTauxInteret(4.0);
            credit4a.setMotif("Travaux");
            credit4a = creditPersonnelRepo.save(credit4a);

            CreditImmobilier credit4b = new CreditImmobilier();
            credit4b.setClient(client4);
            credit4b.setDateDemande(LocalDate.now().minusMonths(6));
            credit4b.setStatut("En cours");
            credit4b.setMontant(150000);
            credit4b.setDuree(180);
            credit4b.setTauxInteret(3.5);
            credit4b.setTypeBien("Appartement");
            credit4b = creditImmobilierRepo.save(credit4b);

            System.out.println("✅ Plusieurs clients et crédits insérés dans MySQL !");
        };
    }
}

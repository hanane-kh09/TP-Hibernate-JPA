package ma.projet.test;

import ma.projet.classes.*;
import ma.projet.service.*;

import java.time.LocalDate;

public class MainTest {

    static EmployeService employeService = new EmployeService();
    static ProjetService projetService = new ProjetService();
    static TacheService tacheService = new TacheService();
    static EmployeTacheService employeTacheService = new EmployeTacheService();

    public static void main(String[] args) {
        System.out.println("  TEST 1 : Insertion de données");
        insererDonnees();

        System.out.println("  TEST 2 : Tâches par employé");
        employeService.afficherTachesParEmploye(1);

        System.out.println("  TEST 3 : Projets gérés par employé");
        employeService.afficherProjetsGeresParEmploye(1);

        System.out.println("  TEST 4 : Tâches planifiées par projet");
        projetService.afficherTachesPlanifieesParProjet(1);

        System.out.println("  TEST 5 : Tâches réalisées par projet");
        projetService.afficherTachesRealiseesPourProjet(1);

        System.out.println("  TEST 6 : Tâches prix > 1000 DH");
        tacheService.afficherTachesParPrixSuperieurA1000();

        System.out.println("  TEST 7 : Tâches entre deux dates");
        tacheService.afficherTachesEntreDeuxDates(
                LocalDate.of(2013, 1, 1),
                LocalDate.of(2013, 12, 31)
        );
    }

    static void insererDonnees() {
        Employe e1 = new Employe("Martin", "Alice", "0612345678");
        Employe e2 = new Employe("Dupont", "Bob", "0698765432");
        employeService.create(e1);
        employeService.create(e2);

        Projet p1 = new Projet("Gestion de stock", LocalDate.of(2013, 1, 14), LocalDate.of(2013, 6, 30), e1);
        Projet p2 = new Projet("CRM Entreprise", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 9, 30), e2);
        projetService.create(p1);
        projetService.create(p2);

        Tache t1 = new Tache("Analyse", LocalDate.of(2013, 2, 1), LocalDate.of(2013, 2, 28), 1500.0, p1);
        Tache t2 = new Tache("Conception", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 3, 31), 2000.0, p1);
        Tache t3 = new Tache("Développement", LocalDate.of(2013, 4, 1), LocalDate.of(2013, 5, 31), 5000.0, p1);
        Tache t4 = new Tache("Tests", LocalDate.of(2013, 4, 1), LocalDate.of(2013, 4, 30), 800.0, p2);
        tacheService.create(t1);
        tacheService.create(t2);
        tacheService.create(t3);
        tacheService.create(t4);

        EmployeTache et1 = new EmployeTache(LocalDate.of(2013, 2, 10), LocalDate.of(2013, 2, 20), e1, t1);
        EmployeTache et2 = new EmployeTache(LocalDate.of(2013, 3, 10), LocalDate.of(2013, 3, 15), e1, t2);
        EmployeTache et3 = new EmployeTache(LocalDate.of(2013, 4, 10), LocalDate.of(2013, 4, 25), e2, t3);
        employeTacheService.create(et1);
        employeTacheService.create(et2);
        employeTacheService.create(et3);

    }
}

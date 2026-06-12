package ma.projet.test;

import ma.projet.beans.*;
import ma.projet.service.*;

import java.time.LocalDate;

public class MainTest {

    static FemmeService femmeService = new FemmeService();
    static HommeService hommeService = new HommeService();
    static MariageService mariageService = new MariageService();

    public static void main(String[] args) {

        System.out.println("  TEST 1 : Insertion de données");
        insererDonnees();

        System.out.println("  TEST 2 : Liste de toutes les femmes");

        femmeService.afficherToutesLesFemmes();

        System.out.println("  TEST 3 : Femme la plus âgée");
        femmeService.afficherFemmeLaPlusAgee();

        System.out.println("  TEST 4 : Épouses d'un homme entre deux dates");
        hommeService.afficherEpousesEntreDeuxDates(1,
                LocalDate.of(1985, 1, 1),
                LocalDate.of(2010, 12, 31));

        System.out.println("  TEST 5 : Nbr enfants d'une femme entre deux dates");
        femmeService.afficherNbrEnfantsEntreDates(1,
                LocalDate.of(1985, 1, 1),
                LocalDate.of(2010, 12, 31));

        System.out.println("  TEST 6 : Femmes mariées au moins deux fois");
        femmeService.afficherFemmesMarieesAuMoinsDeuXFois();

        System.out.println("  TEST 7 : Hommes mariés à 4 femmes entre deux dates (Criteria API)");
        hommeService.afficherHommesMariesAQuatreFemmesEntreDeuxDates(
                LocalDate.of(1985, 1, 1),
                LocalDate.of(2024, 12, 31));

        System.out.println("\n========================================");
        System.out.println("  TEST 8 : Détails des mariages d'un homme");
        System.out.println("========================================");
        hommeService.afficherMariagesHomme(1);
    }

    static void insererDonnees() {
        Femme f1 = new Femme("RAMI", "Salima", "0611000001", "Casablanca", LocalDate.of(1970, 3, 15));
        Femme f2 = new Femme("ALI", "Amal", "0611000002", "Rabat", LocalDate.of(1975, 7, 20));
        Femme f3 = new Femme("ALAOUI", "Wafa", "0611000003", "Fès", LocalDate.of(1978, 11, 4));
        Femme f4 = new Femme("ALAMI", "Karima", "0611000004", "Marrakech", LocalDate.of(1968, 9, 3));
        Femme f5 = new Femme("BENALI", "Nadia", "0611000005", "Agadir", LocalDate.of(1980, 1, 10));
        Femme f6 = new Femme("CHAOUI", "Houda", "0611000006", "Tanger", LocalDate.of(1982, 5, 22));
        Femme f7 = new Femme("MANSOURI", "Loubna", "0611000007", "Oujda", LocalDate.of(1985, 8, 17));
        Femme f8 = new Femme("TAHIRI", "Zineb", "0611000008", "Meknes", LocalDate.of(1990, 2, 28));
        Femme f9 = new Femme("IDRISSI", "Sara", "0611000009", "Safi", LocalDate.of(1992, 6, 5));
        Femme f10 = new Femme("ZIANI", "Fatima", "0611000010", "Kenitra", LocalDate.of(1965, 12, 30));

        femmeService.create(f1);
        femmeService.create(f2);
        femmeService.create(f3);
        femmeService.create(f4);
        femmeService.create(f5);
        femmeService.create(f6);
        femmeService.create(f7);
        femmeService.create(f8);
        femmeService.create(f9);
        femmeService.create(f10);

        Homme h1 = new Homme("SAFI", "Said", "0622000001", "Casablanca", LocalDate.of(1960, 4, 12));
        Homme h2 = new Homme("BENNIS", "Youssef", "0622000002", "Rabat", LocalDate.of(1965, 9, 8));
        Homme h3 = new Homme("CHRAIBI", "Omar", "0622000003", "Fès", LocalDate.of(1972, 1, 25));
        Homme h4 = new Homme("FASSI", "Khalid", "0622000004", "Marrakech", LocalDate.of(1968, 7, 14));
        Homme h5 = new Homme("BERRADA", "Hassan", "0622000005", "Agadir", LocalDate.of(1955, 3, 3));

        hommeService.create(h1);
        hommeService.create(h2);
        hommeService.create(h3);
        hommeService.create(h4);
        hommeService.create(h5);

        mariageService.create(new Mariage(LocalDate.of(1989, 9, 3), LocalDate.of(1990, 9, 3), 0, h1, f4));
        mariageService.create(new Mariage(LocalDate.of(1990, 9, 3), null, 4, h1, f1));
        mariageService.create(new Mariage(LocalDate.of(1995, 9, 3), null, 2, h1, f2));
        mariageService.create(new Mariage(LocalDate.of(2000, 11, 4), null, 3, h1, f3));

        mariageService.create(new Mariage(LocalDate.of(1990, 5, 10), LocalDate.of(1995, 5, 10), 1, h2, f5));
        mariageService.create(new Mariage(LocalDate.of(1996, 3, 1), null, 2, h2, f6));
        mariageService.create(new Mariage(LocalDate.of(2000, 7, 15), null, 1, h2, f7));

        mariageService.create(new Mariage(LocalDate.of(1998, 2, 14), null, 3, h3, f8));

        mariageService.create(new Mariage(LocalDate.of(1988, 6, 20), LocalDate.of(1992, 6, 20), 2, h4, f9));
        mariageService.create(new Mariage(LocalDate.of(1993, 8, 5), null, 1, h4, f10));
        mariageService.create(new Mariage(LocalDate.of(2001, 1, 1), null, 0, h4, f5));
        mariageService.create(new Mariage(LocalDate.of(2005, 3, 3), null, 2, h4, f6));

        mariageService.create(new Mariage(LocalDate.of(1975, 11, 11), LocalDate.of(1980, 11, 11), 3, h5, f10));
        mariageService.create(new Mariage(LocalDate.of(1982, 4, 4), null, 5, h5, f9));

    }
}

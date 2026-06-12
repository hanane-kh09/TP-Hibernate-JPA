package ma.projet.test;

import ma.projet.classes.*;
import ma.projet.service.*;
import ma.projet.util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainTest {

    static CategorieService categorieService = new CategorieService();
    static ProduitService produitService = new ProduitService();
    static CommandeService commandeService = new CommandeService();
    static LigneCommandeService ligneService = new LigneCommandeService();

    public static void main(String[] args) throws Exception {

        System.out.println("  TEST 1 : Insertion de données");
        insererDonnees();

        System.out.println("  TEST 2 : Produits par catégorie");
        testProduitsByCategorie();

        System.out.println("  TEST 3 : Produits commandés entre dates");
        testProduitsBetweenDates();

        System.out.println("  TEST 4 : Produits d'une commande");
        testProduitsParCommande();

        System.out.println("  TEST 5 : Produits prix > 100 DH (NamedQuery)");
        testPrixSuperieur100();

        HibernateUtil.shutdown();
    }



    static Commande cmdTest;

    private static void insererDonnees() throws Exception {
        Categorie catInfo = new Categorie("INFO", "Informatique");
        Categorie catReseau = new Categorie("RES", "Réseau");
        categorieService.create(catInfo);
        categorieService.create(catReseau);
        System.out.println("Catégories créées : " + catInfo + " | " + catReseau);

        Produit p1 = new Produit("ES12", 120f, catInfo);
        Produit p2 = new Produit("ZR85", 100f, catInfo);
        Produit p3 = new Produit("EE85", 200f, catReseau);
        Produit p4 = new Produit("SW01", 80f, catReseau);
        produitService.create(p1);
        produitService.create(p2);
        produitService.create(p3);
        produitService.create(p4);
        System.out.println("Produits créés.");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Commande cmd1 = new Commande(sdf.parse("2013-03-14"));
        Commande cmd2 = new Commande(sdf.parse("2024-01-10"));
        commandeService.create(cmd1);
        commandeService.create(cmd2);
        cmdTest = cmd1;
        System.out.println("Commandes créées : " + cmd1 + " | " + cmd2);

        ligneService.create(new LigneCommandeProduit(7, cmd1, p1));
        ligneService.create(new LigneCommandeProduit(14, cmd1, p2));
        ligneService.create(new LigneCommandeProduit(5, cmd1, p3));
        ligneService.create(new LigneCommandeProduit(3, cmd2, p4));
        System.out.println("Lignes de commande créées.");
    }


    private static void testProduitsByCategorie() {
        List<Categorie> categories = categorieService.findAll();
        for (Categorie cat : categories) {
            System.out.println("\nCatégorie : " + cat.getLibelle());
            List<Produit> produits = produitService.findByCategorie(cat);
            produits.forEach(p ->
                System.out.println("  -> " + p.getReference() + " | " + p.getPrix() + " DH")
            );
        }
    }


    private static void testProduitsBetweenDates() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2013-01-01");
        Date d2 = sdf.parse("2013-12-31");
        List<Produit> produits = produitService.findProduitsBetweenDates(d1, d2);
        System.out.println("Produits commandés en 2013 :");
        produits.forEach(p -> System.out.println("  -> " + p.getReference()));
    }


    private static void testProduitsParCommande() {
        produitService.findLignesByCommande(cmdTest);
    }


    private static void testPrixSuperieur100() {
        List<Produit> produits = produitService.findPrixSuperieur100();
        System.out.println("Produits avec prix > 100 DH :");
        produits.forEach(p ->
            System.out.println("  -> " + p.getReference() + " | " + p.getPrix() + " DH")
        );
    }
}

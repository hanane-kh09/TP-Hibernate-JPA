package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit produit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(produit);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur create Produit : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Produit produit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(produit);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur update Produit : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Produit produit) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Produit managed = session.merge(produit);
            session.remove(managed);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur delete Produit : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Produit findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Produit.class, id);
        }
    }

    @Override
    public List<Produit> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Produit", Produit.class).list();
        }
    }


    public List<Produit> findByCategorie(Categorie categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Produit p WHERE p.categorie = :cat", Produit.class)
                    .setParameter("cat", categorie)
                    .list();
        }
    }


    public List<Produit> findProduitsBetweenDates(Date dateDebut, Date dateFin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT DISTINCT lcp.produit FROM LigneCommandeProduit lcp " +
                    "WHERE lcp.commande.date BETWEEN :dateDebut AND :dateFin", Produit.class)
                    .setParameter("dateDebut", dateDebut)
                    .setParameter("dateFin", dateFin)
                    .list();
        }
    }

    public List<LigneCommandeProduit> findLignesByCommande(Commande commande) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Commande managed = session.get(Commande.class, commande.getId());
            if (managed == null) return List.of();

            List<LigneCommandeProduit> lignes = session.createQuery(
                    "FROM LigneCommandeProduit lcp " +
                    "JOIN FETCH lcp.produit " +
                    "WHERE lcp.commande = :cmd", LigneCommandeProduit.class)
                    .setParameter("cmd", managed)
                    .list();

            System.out.printf("Commande : %-5d Date : %s%n", managed.getId(), managed.getDate());
            System.out.println("Liste des produits :");
            System.out.printf("%-12s %-10s %s%n", "Référence", "Prix", "Quantité");
            for (LigneCommandeProduit l : lignes) {
                System.out.printf("%-12s %-10s %d%n",
                        l.getProduit().getReference(),
                        (int) l.getProduit().getPrix() + " DH",
                        l.getQuantite());
            }
            return lignes;
        }
    }


    public List<Produit> findPrixSuperieur100() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNamedQuery("Produit.prixSuperieur100", Produit.class).list();
        }
    }
}

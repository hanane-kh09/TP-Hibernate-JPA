package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProjetService implements IDao<Projet> {

    @Override
    public void create(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(projet);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(projet);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(projet) ? projet : session.merge(projet));
        tx.commit();
        session.close();
    }

    @Override
    public Projet findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Projet projet = session.get(Projet.class, id);
        session.close();
        return projet;
    }

    @Override
    public List<Projet> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Projet> list = session.createQuery("FROM Projet", Projet.class).list();
        session.close();
        return list;
    }

    public List<Tache> getTachesPlanifieesParProjet(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery(
                "FROM Tache t WHERE t.projet.id = :id", Tache.class)
                .setParameter("id", projetId)
                .list();
        session.close();
        return taches;
    }

    public List<EmployeTache> getTachesRealiseesPourProjet(int projetId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeTache> employeTaches = session.createQuery(
                "FROM EmployeTache et WHERE et.tache.projet.id = :id", EmployeTache.class)
                .setParameter("id", projetId)
                .list();
        session.close();
        return employeTaches;
    }

    public void afficherTachesPlanifieesParProjet(int projetId) {
        Projet projet = findById(projetId);
        if (projet == null) {
            System.out.println("Projet introuvable.");
            return;
        }
        System.out.println("Projet : " + projet.getId() + "      Nom : " + projet.getNom()
                + "     Date début : " + projet.getDateDebut());
        System.out.println("Liste des tâches planifiées :");
        System.out.printf("%-5s %-20s %-12s %-12s %-10s%n", "Num", "Nom", "Date Début", "Date Fin", "Prix");
        for (Tache t : getTachesPlanifieesParProjet(projetId)) {
            System.out.printf("%-5d %-20s %-12s %-12s %-10.2f%n",
                    t.getId(), t.getNom(), t.getDateDebut(), t.getDateFin(), t.getPrix());
        }
    }

    public void afficherTachesRealiseesPourProjet(int projetId) {
        Projet projet = findById(projetId);
        if (projet == null) {
            System.out.println("Projet introuvable.");
            return;
        }
        System.out.println("Projet : " + projet.getId() + "      Nom : " + projet.getNom()
                + "     Date début : " + projet.getDateDebut());
        System.out.println("Liste des tâches réalisées :");
        System.out.printf("%-5s %-20s %-20s %-20s%n", "Num", "Nom", "Date Début Réelle", "Date Fin Réelle");
        for (EmployeTache et : getTachesRealiseesPourProjet(projetId)) {
            System.out.printf("%-5d %-20s %-20s %-20s%n",
                    et.getTache().getId(),
                    et.getTache().getNom(),
                    et.getDateDebutReelle(),
                    et.getDateFinReelle());
        }
    }
}

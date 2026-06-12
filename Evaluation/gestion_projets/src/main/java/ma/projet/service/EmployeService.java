package ma.projet.service;

import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeService implements IDao<Employe> {

    @Override
    public void create(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employe);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(employe);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(employe) ? employe : session.merge(employe));
        tx.commit();
        session.close();
    }

    @Override
    public Employe findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employe employe = session.get(Employe.class, id);
        session.close();
        return employe;
    }

    @Override
    public List<Employe> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employe> list = session.createQuery("FROM Employe", Employe.class).list();
        session.close();
        return list;
    }

    public List<Tache> getTachesParEmploye(int employeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> taches = session.createQuery(
                "SELECT et.tache FROM EmployeTache et WHERE et.employe.id = :id", Tache.class)
                .setParameter("id", employeId)
                .list();
        session.close();
        return taches;
    }

    public List<Projet> getProjetsGeresParEmploye(int employeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Projet> projets = session.createQuery(
                "FROM Projet p WHERE p.chefDeProjet.id = :id", Projet.class)
                .setParameter("id", employeId)
                .list();
        session.close();
        return projets;
    }

    public void afficherTachesParEmploye(int employeId) {
        Employe employe = findById(employeId);
        if (employe == null) {
            System.out.println("Employé introuvable.");
            return;
        }
        System.out.println("Tâches réalisées par : " + employe.getNom() + " " + employe.getPrenom());
        System.out.printf("%-5s %-20s %-12s %-12s %-10s%n", "Id", "Nom", "Date Début", "Date Fin", "Prix");
        for (Tache t : getTachesParEmploye(employeId)) {
            System.out.printf("%-5d %-20s %-12s %-12s %-10.2f%n",
                    t.getId(), t.getNom(), t.getDateDebut(), t.getDateFin(), t.getPrix());
        }
    }

    public void afficherProjetsGeresParEmploye(int employeId) {
        Employe employe = findById(employeId);
        if (employe == null) {
            System.out.println("Employé introuvable.");
            return;
        }
        System.out.println("Projets gérés par : " + employe.getNom() + " " + employe.getPrenom());
        System.out.printf("%-5s %-25s %-12s %-12s%n", "Id", "Nom", "Date Début", "Date Fin");
        for (Projet p : getProjetsGeresParEmploye(employeId)) {
            System.out.printf("%-5d %-25s %-12s %-12s%n",
                    p.getId(), p.getNom(), p.getDateDebut(), p.getDateFin());
        }
    }
}

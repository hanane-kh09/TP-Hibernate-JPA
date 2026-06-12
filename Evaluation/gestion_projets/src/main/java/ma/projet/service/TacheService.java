package ma.projet.service;

import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class TacheService implements IDao<Tache> {

    @Override
    public void create(Tache tache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(tache);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Tache tache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(tache);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Tache tache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(tache) ? tache : session.merge(tache));
        tx.commit();
        session.close();
    }

    @Override
    public Tache findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Tache tache = session.get(Tache.class, id);
        session.close();
        return tache;
    }

    @Override
    public List<Tache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> list = session.createQuery("FROM Tache", Tache.class).list();
        session.close();
        return list;
    }

    public List<Tache> getTachesParPrixSuperieurA1000() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> list = session.createNamedQuery("Tache.findByPrixSuperieurA1000", Tache.class).list();
        session.close();
        return list;
    }

    public List<Tache> getTachesEntreDeuxDates(LocalDate debut, LocalDate fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tache> list = session.createQuery(
                "FROM Tache t WHERE t.dateDebut >= :debut AND t.dateFin <= :fin", Tache.class)
                .setParameter("debut", debut)
                .setParameter("fin", fin)
                .list();
        session.close();
        return list;
    }

    public void afficherTachesParPrixSuperieurA1000() {
        System.out.println("Tâches dont le prix est supérieur à 1000 DH :");
        System.out.printf("%-5s %-20s %-12s %-12s %-10s%n", "Id", "Nom", "Date Début", "Date Fin", "Prix");
        for (Tache t : getTachesParPrixSuperieurA1000()) {
            System.out.printf("%-5d %-20s %-12s %-12s %-10.2f%n",
                    t.getId(), t.getNom(), t.getDateDebut(), t.getDateFin(), t.getPrix());
        }
    }

    public void afficherTachesEntreDeuxDates(LocalDate debut, LocalDate fin) {
        System.out.println("Tâches réalisées entre " + debut + " et " + fin + " :");
        System.out.printf("%-5s %-20s %-12s %-12s %-10s%n", "Id", "Nom", "Date Début", "Date Fin", "Prix");
        for (Tache t : getTachesEntreDeuxDates(debut, fin)) {
            System.out.printf("%-5d %-20s %-12s %-12s %-10.2f%n",
                    t.getId(), t.getNom(), t.getDateDebut(), t.getDateFin(), t.getPrix());
        }
    }
}

package ma.projet.service;

import ma.projet.classes.Commande;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommandeService implements IDao<Commande> {

    @Override
    public boolean create(Commande commande) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(commande);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur create Commande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Commande commande) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(commande);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur update Commande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Commande commande) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Commande managed = session.merge(commande);
            session.remove(managed);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur delete Commande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Commande findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Commande.class, id);
        }
    }

    @Override
    public List<Commande> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Commande", Commande.class).list();
        }
    }
}

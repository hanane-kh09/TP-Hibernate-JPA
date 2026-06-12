package ma.projet.service;

import ma.projet.classes.LigneCommandeProduit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LigneCommandeService implements IDao<LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit ligne) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ligne);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur create LigneCommande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(LigneCommandeProduit ligne) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ligne);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur update LigneCommande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(LigneCommandeProduit ligne) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            LigneCommandeProduit managed = session.merge(ligne);
            session.remove(managed);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur delete LigneCommande : " + e.getMessage());
            return false;
        }
    }

    @Override
    public LigneCommandeProduit findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(LigneCommandeProduit.class, id);
        }
    }

    @Override
    public List<LigneCommandeProduit> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM LigneCommandeProduit", LigneCommandeProduit.class).list();
        }
    }
}

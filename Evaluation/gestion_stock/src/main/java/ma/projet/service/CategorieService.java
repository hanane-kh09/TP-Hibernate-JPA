package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(categorie);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur create Categorie : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Categorie categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(categorie);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur update Categorie : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Categorie categorie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Categorie managed = session.merge(categorie);
            session.remove(managed);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erreur delete Categorie : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Categorie findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Categorie.class, id);
        }
    }

    @Override
    public List<Categorie> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Categorie", Categorie.class).list();
        }
    }
}

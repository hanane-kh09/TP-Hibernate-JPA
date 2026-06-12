package ma.projet.service;

import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MariageService implements IDao<Mariage> {

    @Override
    public void create(Mariage mariage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(mariage);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Mariage mariage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(mariage);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Mariage mariage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(mariage) ? mariage : session.merge(mariage));
        tx.commit();
        session.close();
    }

    @Override
    public Mariage findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Mariage mariage = session.get(Mariage.class, id);
        session.close();
        return mariage;
    }

    @Override
    public List<Mariage> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mariage> list = session.createQuery("FROM Mariage", Mariage.class).list();
        session.close();
        return list;
    }
}

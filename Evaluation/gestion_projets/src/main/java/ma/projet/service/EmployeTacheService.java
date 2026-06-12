package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public void create(EmployeTache employeTache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employeTache);
        tx.commit();
        session.close();
    }

    @Override
    public void update(EmployeTache employeTache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(employeTache);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(EmployeTache employeTache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(employeTache) ? employeTache : session.merge(employeTache));
        tx.commit();
        session.close();
    }

    @Override
    public EmployeTache findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EmployeTache et = session.get(EmployeTache.class, id);
        session.close();
        return et;
    }

    @Override
    public List<EmployeTache> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeTache> list = session.createQuery("FROM EmployeTache", EmployeTache.class).list();
        session.close();
        return list;
    }
}

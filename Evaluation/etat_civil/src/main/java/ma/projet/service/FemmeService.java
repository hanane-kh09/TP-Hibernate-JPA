package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class FemmeService implements IDao<Femme> {

    @Override
    public void create(Femme femme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(femme);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Femme femme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(femme);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Femme femme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(femme) ? femme : session.merge(femme));
        tx.commit();
        session.close();
    }

    @Override
    public Femme findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Femme femme = session.get(Femme.class, id);
        session.close();
        return femme;
    }

    @Override
    public List<Femme> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Femme> list = session.createQuery("FROM Femme", Femme.class).list();
        session.close();
        return list;
    }

    public Femme getFemmeLaPlusAgee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Femme femme = session.createQuery(
                "FROM Femme f ORDER BY f.dateNaissance ASC", Femme.class)
                .setMaxResults(1)
                .uniqueResult();
        session.close();
        return femme;
    }

    public int getNbrEnfantsEntreDates(int femmeId, LocalDate debut, LocalDate fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Number result = (Number) session.createNativeQuery(
                "SELECT COALESCE(SUM(m.nbr_enfant), 0) FROM mariage m WHERE m.femme_id = :femmeId AND m.date_debut >= :debut AND (m.date_fin <= :fin OR m.date_fin IS NULL)")
                .setParameter("femmeId", femmeId)
                .setParameter("debut", debut)
                .setParameter("fin", fin)
                .uniqueResult();
        session.close();
        return result != null ? result.intValue() : 0;
    }

    public List<Femme> getFemmesMarieesAuMoinsDeuXFois() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Femme> list = session.createNamedQuery("Femme.marieeAuMoinsDeuXFois", Femme.class).list();
        session.close();
        return list;
    }

    public void afficherToutesLesFemmes() {
        System.out.println("Liste de toutes les femmes :");
        System.out.printf("%-5s %-25s %-15s %-30s %-15s%n", "Id", "Nom Complet", "Téléphone", "Adresse", "Date Naissance");
        for (Femme f : findAll()) {
            System.out.printf("%-5d %-25s %-15s %-30s %-15s%n",
                    f.getId(), f.getNomComplet(), f.getTelephone(), f.getAdresse(), f.getDateNaissance());
        }
    }

    public void afficherFemmeLaPlusAgee() {
        Femme f = getFemmeLaPlusAgee();
        if (f == null) {
            System.out.println("Aucune femme enregistrée.");
            return;
        }
        System.out.println("Femme la plus âgée : " + f.getNomComplet() + " — née le " + f.getDateNaissance());
    }

    public void afficherNbrEnfantsEntreDates(int femmeId, LocalDate debut, LocalDate fin) {
        Femme femme = findById(femmeId);
        if (femme == null) {
            System.out.println("Femme introuvable.");
            return;
        }
        int total = getNbrEnfantsEntreDates(femmeId, debut, fin);
        System.out.println("Nombre d'enfants de " + femme.getNomComplet() + " entre " + debut + " et " + fin + " : " + total);
    }

    public void afficherFemmesMarieesAuMoinsDeuXFois() {
        System.out.println("Femmes mariées au moins deux fois :");
        List<Femme> femmes = getFemmesMarieesAuMoinsDeuXFois();
        if (femmes.isEmpty()) {
            System.out.println("  Aucune.");
        } else {
            femmes.forEach(f -> System.out.println("  - " + f.getNomComplet()));
        }
    }
}

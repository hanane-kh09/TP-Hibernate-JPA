package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.*;

import java.time.LocalDate;
import java.util.List;

public class HommeService implements IDao<Homme> {

    @Override
    public void create(Homme homme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(homme);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Homme homme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(homme);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Homme homme) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(session.contains(homme) ? homme : session.merge(homme));
        tx.commit();
        session.close();
    }

    @Override
    public Homme findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Homme homme = session.get(Homme.class, id);
        session.close();
        return homme;
    }

    @Override
    public List<Homme> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Homme> list = session.createQuery("FROM Homme", Homme.class).list();
        session.close();
        return list;
    }

    public List<Femme> getEpousesEntreDeuxDates(int hommeId, LocalDate debut, LocalDate fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Femme> femmes = session.createQuery(
                "SELECT m.femme FROM Mariage m WHERE m.homme.id = :id AND m.dateDebut >= :debut AND (m.dateFin <= :fin OR m.dateFin IS NULL)",
                Femme.class)
                .setParameter("id", hommeId)
                .setParameter("debut", debut)
                .setParameter("fin", fin)
                .list();
        session.close();
        return femmes;
    }

    public void afficherEpousesEntreDeuxDates(int hommeId, LocalDate debut, LocalDate fin) {
        Homme homme = findById(hommeId);
        if (homme == null) {
            System.out.println("Homme introuvable.");
            return;
        }
        System.out.println("Épouses de " + homme.getNomComplet() + " entre " + debut + " et " + fin + " :");
        List<Femme> femmes = getEpousesEntreDeuxDates(hommeId, debut, fin);
        if (femmes.isEmpty()) {
            System.out.println("  Aucune épouse trouvée.");
        } else {
            femmes.forEach(f -> System.out.println("  - " + f.getNomComplet()));
        }
    }

    public long getNombreHommesMariesAQuatreFemmesEntreDeuxDates(LocalDate debut, LocalDate fin) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Homme> root = cq.from(Homme.class);
        Join<Homme, Mariage> mariageJoin = root.join("mariages");

        cq.select(cb.countDistinct(root))
          .where(
              cb.greaterThanOrEqualTo(mariageJoin.get("dateDebut"), debut),
              cb.or(
                  cb.lessThanOrEqualTo(mariageJoin.get("dateFin"), fin),
                  cb.isNull(mariageJoin.get("dateFin"))
              )
          )
          .groupBy(root.get("id"))
          .having(cb.ge(cb.count(mariageJoin), 4L));

        List<Long> results = session.createQuery(cq).list();
        session.close();
        return results.size();
    }

    public void afficherHommesMariesAQuatreFemmesEntreDeuxDates(LocalDate debut, LocalDate fin) {
        long count = getNombreHommesMariesAQuatreFemmesEntreDeuxDates(debut, fin);
        System.out.println("Nombre d'hommes mariés à 4 femmes entre " + debut + " et " + fin + " : " + count);
    }

    public void afficherMariagesHomme(int hommeId) {
        Homme homme = findById(hommeId);
        if (homme == null) {
            System.out.println("Homme introuvable.");
            return;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Mariage> mariages = session.createQuery(
                "FROM Mariage m WHERE m.homme.id = :id ORDER BY m.dateDebut", Mariage.class)
                .setParameter("id", hommeId)
                .list();
        session.close();

        System.out.println("Nom : " + homme.getNomComplet().toUpperCase());

        List<Mariage> enCours = mariages.stream().filter(Mariage::enCours).toList();
        List<Mariage> termines = mariages.stream().filter(m -> !m.enCours()).toList();

        if (!enCours.isEmpty()) {
            System.out.println("Mariages En Cours :");
            int i = 1;
            for (Mariage m : enCours) {
                System.out.printf("%d. Femme : %-20s Date Début : %s    Nbr Enfants : %d%n",
                        i++, m.getFemme().getNomComplet().toUpperCase(), m.getDateDebut(), m.getNbrEnfant());
            }
        }

        if (!termines.isEmpty()) {
            System.out.println("\nMariages échoués :");
            int i = 1;
            for (Mariage m : termines) {
                System.out.printf("%d. Femme : %-20s Date Début : %s%n",
                        i++, m.getFemme().getNomComplet().toUpperCase(), m.getDateDebut());
                System.out.printf("   Date Fin : %s    Nbr Enfants : %d%n", m.getDateFin(), m.getNbrEnfant());
            }
        }
    }
}

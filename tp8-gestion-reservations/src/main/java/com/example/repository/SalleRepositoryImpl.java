package com.example.repository;

import com.example.model.Salle;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SalleRepositoryImpl implements SalleRepository {

    private final EntityManager em;

    public SalleRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Salle save(Salle salle) {
        if (salle.getId() == null) {
            em.persist(salle);
            return salle;
        } else {
            return em.merge(salle);
        }
    }

    @Override
    public Optional<Salle> findById(Long id) {
        return Optional.ofNullable(em.find(Salle.class, id));
    }

    @Override
    public List<Salle> findAll() {
        return em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
    }

    @Override
    public void delete(Salle salle) {
        em.remove(em.contains(salle) ? salle : em.merge(salle));
    }

    @Override
    public List<Salle> findAvailableRooms(LocalDateTime dateDebut, LocalDateTime dateFin) {
        return em.createQuery(
            "SELECT DISTINCT s FROM Salle s WHERE s.id NOT IN " +
            "(SELECT r.salle.id FROM Reservation r " +
            "WHERE r.statut = com.example.model.StatutReservation.CONFIRMEE " +
            "AND r.dateDebut < :dateFin AND r.dateFin > :dateDebut)",
            Salle.class)
            .setParameter("dateDebut", dateDebut)
            .setParameter("dateFin", dateFin)
            .getResultList();
    }

    @Override
    public List<Salle> searchRooms(Map<String, Object> criteres) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Salle> cq = cb.createQuery(Salle.class);
        Root<Salle> root = cq.from(Salle.class);
        List<Predicate> predicates = new ArrayList<>();

        if (criteres.containsKey("capaciteMin")) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("capacite"), (Integer) criteres.get("capaciteMin")));
        }
        if (criteres.containsKey("capaciteMax")) {
            predicates.add(cb.lessThanOrEqualTo(root.get("capacite"), (Integer) criteres.get("capaciteMax")));
        }
        if (criteres.containsKey("batiment")) {
            predicates.add(cb.equal(root.get("batiment"), criteres.get("batiment")));
        }
        if (criteres.containsKey("etage")) {
            predicates.add(cb.equal(root.get("etage"), criteres.get("etage")));
        }
        if (criteres.containsKey("equipement")) {
            Join<Object, Object> equipementsJoin = root.join("equipements");
            predicates.add(cb.equal(equipementsJoin.get("id"), criteres.get("equipement")));
            cq.distinct(true);
        }

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.asc(root.get("nom")));

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Salle> getPaginatedRooms(int page, int pageSize) {
        return em.createQuery("SELECT s FROM Salle s ORDER BY s.id", Salle.class)
            .setFirstResult((page - 1) * pageSize)
            .setMaxResults(pageSize)
            .getResultList();
    }

    @Override
    public long countRooms() {
        return em.createQuery("SELECT COUNT(s) FROM Salle s", Long.class).getSingleResult();
    }
}

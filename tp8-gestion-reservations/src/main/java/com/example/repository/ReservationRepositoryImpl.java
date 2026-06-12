package com.example.repository;

import com.example.model.Reservation;
import com.example.model.StatutReservation;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ReservationRepositoryImpl implements ReservationRepository {

    private final EntityManager em;

    public ReservationRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Reservation save(Reservation reservation) {
        if (reservation.getId() == null) {
            em.persist(reservation);
            return reservation;
        } else {
            return em.merge(reservation);
        }
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return Optional.ofNullable(em.find(Reservation.class, id));
    }

    @Override
    public List<Reservation> findAll() {
        return em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
    }

    @Override
    public void delete(Reservation reservation) {
        em.remove(em.contains(reservation) ? reservation : em.merge(reservation));
    }

    @Override
    public List<Reservation> findByStatut(StatutReservation statut) {
        return em.createQuery("SELECT r FROM Reservation r WHERE r.statut = :statut", Reservation.class)
            .setParameter("statut", statut)
            .getResultList();
    }

    @Override
    public List<Reservation> findByDateRange(LocalDateTime debut, LocalDateTime fin) {
        return em.createQuery(
            "SELECT r FROM Reservation r WHERE r.dateDebut >= :debut AND r.dateFin <= :fin",
            Reservation.class)
            .setParameter("debut", debut)
            .setParameter("fin", fin)
            .getResultList();
    }
}

package com.example.service;

import com.example.model.Reservation;
import com.example.model.StatutReservation;
import com.example.repository.ReservationRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {

    private final EntityManager em;
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(EntityManager em, ReservationRepository reservationRepository) {
        this.em = em;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        em.getTransaction().begin();
        try {
            Reservation saved = reservationRepository.save(reservation);
            em.getTransaction().commit();
            return saved;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        em.getTransaction().begin();
        try {
            Reservation updated = reservationRepository.save(reservation);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void cancelReservation(Long id) {
        em.getTransaction().begin();
        try {
            reservationRepository.findById(id).ifPresent(r -> {
                r.setStatut(StatutReservation.ANNULEE);
                reservationRepository.save(r);
            });
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Reservation> findByStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }

    @Override
    public List<Reservation> findByDateRange(LocalDateTime debut, LocalDateTime fin) {
        return reservationRepository.findByDateRange(debut, fin);
    }
}

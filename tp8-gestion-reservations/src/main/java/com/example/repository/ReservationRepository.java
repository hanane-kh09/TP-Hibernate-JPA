package com.example.repository;

import com.example.model.Reservation;
import com.example.model.StatutReservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();
    void delete(Reservation reservation);
    List<Reservation> findByStatut(StatutReservation statut);
    List<Reservation> findByDateRange(LocalDateTime debut, LocalDateTime fin);
}

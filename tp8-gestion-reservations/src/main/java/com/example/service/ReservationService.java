package com.example.service;

import com.example.model.Reservation;
import com.example.model.StatutReservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();
    Reservation updateReservation(Reservation reservation);
    void cancelReservation(Long id);
    List<Reservation> findByStatut(StatutReservation statut);
    List<Reservation> findByDateRange(LocalDateTime debut, LocalDateTime fin);
}

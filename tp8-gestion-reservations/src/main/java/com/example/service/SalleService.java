package com.example.service;

import com.example.model.Salle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SalleService {
    Salle createSalle(Salle salle);
    Optional<Salle> findById(Long id);
    List<Salle> findAll();
    Salle updateSalle(Salle salle);
    void deleteSalle(Long id);
    List<Salle> findAvailableRooms(LocalDateTime dateDebut, LocalDateTime dateFin);
    List<Salle> searchRooms(Map<String, Object> criteres);
    List<Salle> getPaginatedRooms(int page, int pageSize);
    long countRooms();
    int getTotalPages(int pageSize);
}

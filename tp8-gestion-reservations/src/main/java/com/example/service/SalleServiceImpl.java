package com.example.service;

import com.example.model.Salle;
import com.example.repository.SalleRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SalleServiceImpl implements SalleService {

    private final EntityManager em;
    private final SalleRepository salleRepository;

    public SalleServiceImpl(EntityManager em, SalleRepository salleRepository) {
        this.em = em;
        this.salleRepository = salleRepository;
    }

    @Override
    public Salle createSalle(Salle salle) {
        em.getTransaction().begin();
        try {
            Salle saved = salleRepository.save(salle);
            em.getTransaction().commit();
            return saved;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Optional<Salle> findById(Long id) {
        return salleRepository.findById(id);
    }

    @Override
    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    @Override
    public Salle updateSalle(Salle salle) {
        em.getTransaction().begin();
        try {
            Salle updated = salleRepository.save(salle);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteSalle(Long id) {
        em.getTransaction().begin();
        try {
            salleRepository.findById(id).ifPresent(salleRepository::delete);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Salle> findAvailableRooms(LocalDateTime dateDebut, LocalDateTime dateFin) {
        return salleRepository.findAvailableRooms(dateDebut, dateFin);
    }

    @Override
    public List<Salle> searchRooms(Map<String, Object> criteres) {
        return salleRepository.searchRooms(criteres);
    }

    @Override
    public List<Salle> getPaginatedRooms(int page, int pageSize) {
        return salleRepository.getPaginatedRooms(page, pageSize);
    }

    @Override
    public long countRooms() {
        return salleRepository.countRooms();
    }

    @Override
    public int getTotalPages(int pageSize) {
        long total = countRooms();
        return (int) Math.ceil((double) total / pageSize);
    }
}

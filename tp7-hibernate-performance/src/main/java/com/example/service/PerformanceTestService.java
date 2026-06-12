package com.example.service;

import com.example.model.Auteur;
import com.example.model.Livre;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import javax.persistence.*;
import java.util.List;

public class PerformanceTestService {

    private final EntityManagerFactory emf;

    public PerformanceTestService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void resetStatistics() {
        Session session = emf.createEntityManager().unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();
        stats.clear();
    }

    public void printStatistics(String testName) {
        Session session = emf.createEntityManager().unwrap(Session.class);
        Statistics stats = session.getSessionFactory().getStatistics();

        System.out.println("\n=== Statistiques pour " + testName + " ===");
        System.out.println("Requêtes exécutées: " + stats.getQueryExecutionCount());
        System.out.println("Temps d'exécution des requêtes: " + stats.getQueryExecutionMaxTime() + "ms");
        System.out.println("Entités chargées: " + stats.getEntityLoadCount());
        System.out.println("Hits du cache de second niveau: " + stats.getSecondLevelCacheHitCount());
        System.out.println("Miss du cache de second niveau: " + stats.getSecondLevelCacheMissCount());
        System.out.println("Ratio de hit du cache: " +
                (stats.getSecondLevelCacheHitCount() + stats.getSecondLevelCacheMissCount() > 0 ?
                (double) stats.getSecondLevelCacheHitCount() / (stats.getSecondLevelCacheHitCount() + stats.getSecondLevelCacheMissCount()) : 0));
    }

    public void testN1Problem() {
        resetStatistics();
        long startTime = System.currentTimeMillis();

        EntityManager em = emf.createEntityManager();
        try {
            List<Auteur> auteurs = em.createQuery("SELECT a FROM Auteur a", Auteur.class)
                    .getResultList();

            for (Auteur auteur : auteurs) {
                System.out.println("Auteur: " + auteur.getNom() + " " + auteur.getPrenom());
                System.out.println("Nombre de livres: " + auteur.getLivres().size());

                for (Livre livre : auteur.getLivres()) {
                    System.out.println("  - " + livre.getTitre() + " (" + livre.getAnneePublication() + ")");
                    System.out.println("    Catégories: " + livre.getCategories().size());
                }
            }

        } finally {
            em.close();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution: " + (endTime - startTime) + "ms");
        printStatistics("Problème N+1 sans optimisation");
    }

    public void testJoinFetch() {
        resetStatistics();
        long startTime = System.currentTimeMillis();

        EntityManager em = emf.createEntityManager();
        try {
            List<Auteur> auteurs = em.createQuery(
                    "SELECT DISTINCT a FROM Auteur a LEFT JOIN FETCH a.livres", Auteur.class)
                    .getResultList();

            for (Auteur auteur : auteurs) {
                System.out.println("Auteur: " + auteur.getNom() + " " + auteur.getPrenom());
                System.out.println("Nombre de livres: " + auteur.getLivres().size());

                for (Livre livre : auteur.getLivres()) {
                    System.out.println("  - " + livre.getTitre() + " (" + livre.getAnneePublication() + ")");
                    System.out.println("    Catégories: " + livre.getCategories().size());
                }
            }

        } finally {
            em.close();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution: " + (endTime - startTime) + "ms");
        printStatistics("Résolution avec JOIN FETCH");
    }

    public void testEntityGraph() {
        resetStatistics();
        long startTime = System.currentTimeMillis();

        EntityManager em = emf.createEntityManager();
        try {
            EntityGraph<?> graph = em.getEntityGraph("graph.Livre.categoriesEtAuteur");

            List<Livre> livres = em.createQuery("SELECT l FROM Livre l", Livre.class)
                    .setHint("javax.persistence.fetchgraph", graph)
                    .getResultList();

            for (Livre livre : livres) {
                System.out.println("Livre: " + livre.getTitre() + " (" + livre.getAnneePublication() + ")");
                System.out.println("  Auteur: " + livre.getAuteur().getNom() + " " + livre.getAuteur().getPrenom());
                System.out.println("  Catégories: " + livre.getCategories().size());
            }

        } finally {
            em.close();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution: " + (endTime - startTime) + "ms");
        printStatistics("Résolution avec Entity Graphs");
    }

    public void testSecondLevelCache() {
        System.out.println("\n=== Test du cache de second niveau ===");

        resetStatistics();
        System.out.println("\nPremier accès (miss du cache):");
        EntityManager em1 = emf.createEntityManager();
        try {
            Auteur auteur = em1.find(Auteur.class, 1L);
            System.out.println("Auteur trouvé: " + auteur.getNom() + " " + auteur.getPrenom());
        } finally {
            em1.close();
        }
        printStatistics("Premier accès");

        resetStatistics();
        System.out.println("\nDeuxième accès (hit du cache):");
        EntityManager em2 = emf.createEntityManager();
        try {
            Auteur auteur = em2.find(Auteur.class, 1L);
            System.out.println("Auteur trouvé: " + auteur.getNom() + " " + auteur.getPrenom());
        } finally {
            em2.close();
        }
        printStatistics("Deuxième accès");

        System.out.println("\nTest avec une requête cachée:");

        resetStatistics();
        System.out.println("\nPremier accès à la requête:");
        EntityManager em3 = emf.createEntityManager();
        try {
            TypedQuery<Auteur> query = em3.createQuery(
                    "SELECT a FROM Auteur a WHERE a.nom = :nom", Auteur.class)
                    .setParameter("nom", "Hugo")
                    .setHint("org.hibernate.cacheable", "true");

            List<Auteur> auteurs = query.getResultList();
            for (Auteur auteur : auteurs) {
                System.out.println("Auteur trouvé: " + auteur.getNom() + " " + auteur.getPrenom());
            }
        } finally {
            em3.close();
        }
        printStatistics("Premier accès à la requête");

        resetStatistics();
        System.out.println("\nDeuxième accès à la requête:");
        EntityManager em4 = emf.createEntityManager();
        try {
            TypedQuery<Auteur> query = em4.createQuery(
                    "SELECT a FROM Auteur a WHERE a.nom = :nom", Auteur.class)
                    .setParameter("nom", "Hugo")
                    .setHint("org.hibernate.cacheable", "true");

            List<Auteur> auteurs = query.getResultList();
            for (Auteur auteur : auteurs) {
                System.out.println("Auteur trouvé: " + auteur.getNom() + " " + auteur.getPrenom());
            }
        } finally {
            em4.close();
        }
        printStatistics("Deuxième accès à la requête");
    }

    public void testPerformanceComparison() {
        System.out.println("\n=== Comparaison des performances avec et sans cache ===");

        EntityManager em = emf.createEntityManager();
        try {
            em.unwrap(Session.class).getSessionFactory().getCache().evictAllRegions();

            System.out.println("\nTest sans cache:");
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < 100; i++) {
                Auteur auteur = em.find(Auteur.class, (i % 4) + 1L);
                auteur.getLivres().size();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Temps d'exécution sans cache: " + (endTime - startTime) + "ms");

        } finally {
            em.close();
        }

        System.out.println("\nTest avec cache:");
        resetStatistics();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            EntityManager em2 = emf.createEntityManager();
            try {
                Auteur auteur = em2.find(Auteur.class, (i % 4) + 1L);
                auteur.getLivres().size();
            } finally {
                em2.close();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution avec cache: " + (endTime - startTime) + "ms");
        printStatistics("Test avec cache");
    }
}

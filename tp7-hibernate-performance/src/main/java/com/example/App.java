package com.example;

import com.example.service.DataInitService;
import com.example.service.PerformanceTestService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-performance");

        try {
            DataInitService dataInitService = new DataInitService(emf);
            dataInitService.initData();

            PerformanceTestService performanceTestService = new PerformanceTestService(emf);

            System.out.println("\n\n=== TEST 1: PROBLÈME N+1 SANS OPTIMISATION ===");
            performanceTestService.testN1Problem();

            System.out.println("\n\n=== TEST 2: RÉSOLUTION AVEC JOIN FETCH ===");
            performanceTestService.testJoinFetch();

            System.out.println("\n\n=== TEST 3: RÉSOLUTION AVEC ENTITY GRAPHS ===");
            performanceTestService.testEntityGraph();

            System.out.println("\n\n=== TEST 4: CACHE DE SECOND NIVEAU ===");
            performanceTestService.testSecondLevelCache();

            System.out.println("\n\n=== TEST 5: COMPARAISON DES PERFORMANCES ===");
            performanceTestService.testPerformanceComparison();

        } finally {
            emf.close();
        }
    }
}

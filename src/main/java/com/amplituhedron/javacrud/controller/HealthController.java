package com.amplituhedron.javacrud.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/health")
    public Map<String, String> health() {
        try {
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            return Map.of("status", "healthy", "database", "connected");
        } catch (Exception e) {
            return Map.of("status", "unhealthy", "database", "disconnected");
        }
    }
}

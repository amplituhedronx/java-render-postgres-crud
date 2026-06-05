package com.amplituhedron.javacrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "message", "Simple CRUD API is running! Visit /docs for interactive API documentation.",
            "endpoints", Map.of(
                "add_record", "POST /records/",
                "list_records", "GET /records/",
                "get_record", "GET /records/{id}",
                "health", "GET /health"
            )
        );
    }
}

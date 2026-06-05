package com.amplituhedron.javacrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "message", "Java CRUD API is running",
            "endpoints", Map.of(
                "create_record", "POST /records",
                "list_records", "GET /records",
                "get_record", "GET /records/{id}",
                "swagger_ui", "/swagger-ui.html"
            )
        );
    }
}

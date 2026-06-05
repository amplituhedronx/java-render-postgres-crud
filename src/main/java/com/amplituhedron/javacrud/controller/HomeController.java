package com.amplituhedron.javacrud.controller;

import com.amplituhedron.javacrud.dto.HomeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public HomeResponse home() {
        return new HomeResponse(
            "Simple CRUD API is running! Visit /docs for interactive API documentation.",
            Map.of(
                "add_record", "POST /records/",
                "list_records", "GET /records/",
                "get_record", "GET /records/{id}",
                "health", "GET /health"
            )
        );
    }
}

package com.amplituhedron.javacrud.controller;

import com.amplituhedron.javacrud.dto.RecordRequest;
import com.amplituhedron.javacrud.dto.RecordResponse;
import com.amplituhedron.javacrud.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
@Tag(name = "Records", description = "CRUD operations for records")
public class RecordController {

    private final RecordService recordService;

    @PostMapping
    @Operation(summary = "Create a new record")
    public ResponseEntity<RecordResponse> createRecord(@Valid @RequestBody RecordRequest request) {
        RecordResponse response = recordService.createRecord(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<RecordResponse>> getAllRecords() {
        return ResponseEntity.ok(recordService.getAllRecords());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get record by ID")
    public ResponseEntity<RecordResponse> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(recordService.getRecordById(id));
    }
}

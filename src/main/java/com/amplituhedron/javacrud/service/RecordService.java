package com.amplituhedron.javacrud.service;

import com.amplituhedron.javacrud.dto.RecordRequest;
import com.amplituhedron.javacrud.dto.RecordResponse;
import com.amplituhedron.javacrud.entity.Record;
import com.amplituhedron.javacrud.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    @Transactional
    public RecordResponse createRecord(RecordRequest request) {
        Record record = Record.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Record saved = recordRepository.save(record);
        return mapToResponse(saved);
    }

    public List<RecordResponse> getAllRecords() {
        return recordRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    public RecordResponse getRecordById(Long id) {
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
        return mapToResponse(record);
    }

    private RecordResponse mapToResponse(Record record) {
        return RecordResponse.builder()
                .id(record.getId())
                .title(record.getTitle())
                .content(record.getContent())
                .createdAt(record.getCreatedAt())
                .build();
    }
}

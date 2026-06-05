package com.amplituhedron.javacrud.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecordResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}

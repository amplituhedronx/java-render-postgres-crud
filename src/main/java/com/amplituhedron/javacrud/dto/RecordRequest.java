package com.amplituhedron.javacrud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecordRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String content;
}

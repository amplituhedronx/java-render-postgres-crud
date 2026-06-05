package com.amplituhedron.javacrud.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Map;

@JsonPropertyOrder({"message", "endpoints"})
public record HomeResponse(
    String message,
    Map<String, String> endpoints
) {
}
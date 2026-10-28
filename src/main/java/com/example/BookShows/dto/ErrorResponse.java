package com.example.BookShows.dto;

import jakarta.validation.constraints.NotBlank;

public record ErrorResponse(
    @NotBlank
    String errorMessage
) {}

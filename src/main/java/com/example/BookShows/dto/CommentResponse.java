package com.example.BookShows.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CommentResponse(
        @NotBlank
        String message,
        @NotBlank
        UUID id,
        @NotBlank
        String description,
        UUID eventId,
        UUID parentCommentId
) {}

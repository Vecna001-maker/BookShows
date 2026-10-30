package com.example.BookShows.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CommentResponse(
        String message,
        UUID id,
        String description,
        UUID eventId,
        UUID parentCommentId
) {}

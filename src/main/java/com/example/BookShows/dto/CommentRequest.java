package com.example.BookShows.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CommentRequest(
    @NotBlank
    String description,
    UUID eventId,
    UUID parentCommentId
) {}

package com.example.BookShows.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue
    private UUID commentId;

    String commentDescription;

    private UUID userId;
    private UUID eventId;
    private UUID parentCommentId;
}

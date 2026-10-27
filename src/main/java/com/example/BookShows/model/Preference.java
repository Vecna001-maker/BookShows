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
@Table(name="user_preferences")
public class Preference {
    @Id
    @GeneratedValue
    private UUID preferenceId;
    private boolean preferenceStatus;

    private UUID eventId;
    private UUID userId;
}

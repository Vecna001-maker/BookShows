package com.example.BookShows.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

//this Setter and getter will be appended by LOMBOK
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    public enum Role {ADMIN,USER} ;

    @Id
    @GeneratedValue
    private UUID userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}

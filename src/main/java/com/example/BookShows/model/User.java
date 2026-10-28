package com.example.BookShows.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

//this Setter and getter will be appended by LOMBOK
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    public enum Role {ADMIN,USER} ;
    @Id
    private UUID userId;
    private String userName;
    private String userEmail;
    private String userPassword;

//    we are doing this to access the string value of this enum
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

}

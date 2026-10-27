package com.example.BookShows.model;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

//this Setter and getter will be appended by LOMBOK
@Getter
@Setter
public class User {

    public enum Role {ADMIN,USER} ;

    private UUID userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Role userRole;
    private Instant createdAt;
    private Instant updatedAt;

}

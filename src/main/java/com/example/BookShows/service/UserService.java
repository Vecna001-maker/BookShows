package com.example.BookShows.service;

import com.example.BookShows.exception.NotFoundException;
import com.example.BookShows.model.User;
import com.example.BookShows.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean isValidUser(UUID userId){
        return userRepository.existsById(userId);
    }

    public User.Role fetchUserRole(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return user.getUserRole();
    }

}

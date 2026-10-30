package com.example.BookShows.controller;

import com.example.BookShows.exception.NotFoundException;
import com.example.BookShows.exception.UserNotAdminException;
import com.example.BookShows.model.Event;
import com.example.BookShows.model.User;
import com.example.BookShows.service.EventService;
import com.example.BookShows.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.BookShows.dto.CreateEventDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EventController {

    private final EventService eventService;
    private final UserService userService;
    public EventController(EventService eventService,UserService userService){
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/events/host/{hostId}")
    public ResponseEntity<List<Event>> getAllEventsForUser(@PathVariable UUID hostId) {
        if(hostId == null) {
            throw new NotFoundException("User not found");
        }
        List<Event> events = eventService.getAllEventsForUser(hostId);

        return ResponseEntity.status(HttpStatus.OK).body(events);
    }

    @GetMapping("/events/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable UUID id) {
        Event event = eventService.getEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body(event);
    }

    @PostMapping("/createEvent")
    public ResponseEntity<?> createEvent(@Valid @RequestBody CreateEventDto createEventDto){
        UUID userId = UUID.fromString("a3f5c821-7b42-4c19-9d61-2e8a6f3b1054");

        if(!userService.isValidUser(userId)){
            throw new NotFoundException("User id not found");
        }
        if(userService.fetchUserRole(userId) != User.Role.ADMIN){
            throw new UserNotAdminException("User does not have Admin Role");
        }
        Event event = eventService.createEvent(createEventDto,userId);

//      user method to add , which validates if user exist in db and has admin access

        return ResponseEntity.status(200).body(event);
    }
}

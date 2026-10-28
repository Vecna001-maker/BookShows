package com.example.BookShows.controller;

import com.example.BookShows.model.Event;
import com.example.BookShows.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.example.BookShows.dto.CreateEventDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<?> createEvent(@Valid @RequestBody CreateEventDto createEventDto){
        UUID userId = UUID.fromString("15b09215-b594-4b1c-a845-da1a1e656c27");
        Event event = eventService.createEvent(createEventDto,userId);

        return ResponseEntity.status(200).body(event);
    }
}

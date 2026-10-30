package com.example.BookShows.service;

import com.example.BookShows.dto.CreateEventDto;
import com.example.BookShows.exception.NotFoundException;
import com.example.BookShows.model.Event;
import com.example.BookShows.repository.EventRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Service
public class EventService {

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Event getEvent(UUID eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NotFoundException("Event Not Found"));
    }

    public List<Event> getAllEventsForUser(UUID userId) {
        return eventRepository.findAllByUserId(userId);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event createEvent(CreateEventDto createEventDto, UUID userId){
        Event eventToCreate = new Event();
        eventToCreate.setEventTitle(createEventDto.eventTitle());
        eventToCreate.setEventDescription(createEventDto.eventDescription());
        eventToCreate.setAttachmentUrl(createEventDto.attachmentUrl());
        eventToCreate.setUserId(userId);

        return eventRepository.save(eventToCreate);
    }
}

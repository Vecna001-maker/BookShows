package com.example.BookShows.service;

import com.example.BookShows.dto.CreateEventDto;
import com.example.BookShows.model.Event;
import com.example.BookShows.repository.EventRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@Service
public class EventService {

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }


    public Event createEvent(CreateEventDto createEventDto, UUID userId){
        Event eventToCreate = new Event();
        eventToCreate.setEventTitle(createEventDto.eventTitle());
        eventToCreate.setEventDescription(createEventDto.eventDescription());
        eventToCreate.setAttachmentUrl(createEventDto.attachmentUrl());
        eventToCreate.setUserId(userId);

        Event event = eventRepository.save(eventToCreate);
        return event;
    }
}

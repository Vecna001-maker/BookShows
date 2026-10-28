package com.example.BookShows.repository;

import com.example.BookShows.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EventRepository extends JpaRepository<Event, UUID> {

}

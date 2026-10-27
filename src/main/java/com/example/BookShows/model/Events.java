package com.example.BookShows.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Events {

    private UUID eventId;
    private String eventTitle;
    private String eventDescription;
    private String imageURL;
    private UUID userId;

}

package com.example.BookShows.dto;

import jakarta.validation.constraints.NotBlank;



public record CreateEventDto (
        @NotBlank
        String eventTitle,
        @NotBlank
        String eventDescription,
        String attachmentUrl
)
{

}



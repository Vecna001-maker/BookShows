package com.example.BookShows.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String messge) {
        super("NOT FOUND: " + messge);
    }
}

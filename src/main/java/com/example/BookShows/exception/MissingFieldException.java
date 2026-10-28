package com.example.BookShows.exception;

public class MissingFieldException extends RuntimeException {
    public MissingFieldException(String message) {
        super("NOT PROVIDED: " + message);
    }
}

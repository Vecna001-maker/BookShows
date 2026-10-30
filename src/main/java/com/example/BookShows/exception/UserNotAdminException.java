package com.example.BookShows.exception;

public class UserNotAdminException extends RuntimeException{

    public UserNotAdminException(String message){
        super(message);
    }
}

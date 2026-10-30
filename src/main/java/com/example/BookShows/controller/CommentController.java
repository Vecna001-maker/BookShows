package com.example.BookShows.controller;

import com.example.BookShows.dto.CommentRequest;
import com.example.BookShows.dto.CommentResponse;
import com.example.BookShows.exception.NotFoundException;
import com.example.BookShows.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping("/comment/{id}")
//    public CommentResponse getComment(@PathVariable UUID commentId) {
//        return null;
//    }

    @PostMapping("/comment")
    public ResponseEntity<CommentResponse> postComment(@RequestBody CommentRequest commentDetails) {
        UUID user_id = UUID.fromString("15b09215-b594-4b1c-a845-da1a1e656c27");

//      Although we are hardcoding here, will later implement
        if(user_id == null) {
            throw new NotFoundException("User");
        }

        CommentResponse response = commentService.postComment(commentDetails, user_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

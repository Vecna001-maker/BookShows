package com.example.BookShows.service;

import com.example.BookShows.dto.CommentRequest;
import com.example.BookShows.dto.CommentResponse;
import com.example.BookShows.exception.MissingFieldException;
import com.example.BookShows.exception.NotFoundException;
import com.example.BookShows.model.Comment;
import com.example.BookShows.repository.CommentRepository;
import com.example.BookShows.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final EventRepository eventRepository;

    public CommentService(CommentRepository commentRepository, EventRepository eventRepository) {
        this.commentRepository = commentRepository;
        this.eventRepository = eventRepository;
    }

    public CommentResponse postComment(CommentRequest commentDetails, UUID user_id) {
        if(commentDetails.eventId() == null) {
            throw new MissingFieldException("Event Id not provided");
        }

        boolean doesEventExist = eventRepository.existsById(commentDetails.eventId());
        if(!doesEventExist) {
            throw new NotFoundException("Provided Event not found");
        }

        if(commentDetails.parentCommentId() != null) {
            boolean doesCommentExist = commentRepository.existsById(commentDetails.parentCommentId());
            if(!doesCommentExist) {
                throw new NotFoundException("Provided Comment not found");
            }
        }

        Comment newComment = new Comment(
            commentDetails.description(),
            commentDetails.eventId(),
            commentDetails.parentCommentId(),
            user_id
        );
        Comment savedComment = commentRepository.save(newComment);
        return toResponse(savedComment);
    }

    private CommentResponse toResponse(Comment comment) {
        return new CommentResponse(
            "Comment posted successfully",
                comment.getCommentId(),
                comment.getCommentDescription(),
                comment.getEventId(),
                comment.getParentCommentId()
        );
    }
}

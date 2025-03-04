package com.example.spring.App.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.App.exception.BadRequestException;
import com.example.spring.App.exception.InternalServerErrorException;
import com.example.spring.App.exception.StatusOk;
import com.example.spring.App.model.DTO.CommentsDTO;
import com.example.spring.App.service.CommentsService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCommentsList() {
        try {
            CommentsDTO.ResponseCommentsDTO comments = commentsService.fetchAllComments();

            return StatusOk.Response(comments);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<Object> getCommentsById(@RequestParam String id) {
        try {
            CommentsDTO.ResponseCommentsDTO comments = commentsService.fetchCommentById(id);

            if (comments.getStatus().equals("400")) {
                return BadRequestException.BadRequest("ID is required");
            }

            return StatusOk.Response(comments);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }

    @GetMapping("/comment/email")
    public ResponseEntity<Object> getCommentsByEmail(@RequestParam String email) {
        try {
            CommentsDTO.ResponseCommentsDTO comments = commentsService.fetchCommentsByEmail(email);

            if (comments.getStatus().equals("400")) {
                return BadRequestException.BadRequest("ID is required");
            }

            return StatusOk.Response(comments);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }
}

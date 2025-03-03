package com.example.spring.App.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.App.exception.InternalServerErrorException;
import com.example.spring.App.exception.StatusOk;
import com.example.spring.App.model.DTO.CommetsDTO;
import com.example.spring.App.service.CommentsService;

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
            List<CommetsDTO> comments = commentsService.getAllComments();
            return StatusOk.Response(comments);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }
}

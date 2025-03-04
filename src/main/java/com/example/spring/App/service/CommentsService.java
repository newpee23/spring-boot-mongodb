package com.example.spring.App.service;

import com.example.spring.App.model.DTO.CommentsDTO;
import com.example.spring.App.repository.CommentsRepository;
import com.example.spring.App.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public CommentsDTO.ResponseCommentsDTO fetchAllComments() {
        try {
            List<CommentsDTO> commentsList = commentsRepository.findAll().stream()
                    .map(Utils::convertToCommentsDTO)
                    .collect(Collectors.toList());

            if (commentsList.isEmpty()) {
                return buildResponse(Collections.emptyList(), "No comments found", "200");
            }

            return buildResponse(commentsList, "Fetch successful", "200");
        } catch (Exception e) {
            throw new RuntimeException("Unable to retrieve comments: " + e.getMessage(), e);
        }
    }

    public CommentsDTO.ResponseCommentsDTO fetchCommentById(String id) {
        try {
            if (id == null || id.isEmpty()) {
                return buildResponse(Collections.emptyList(), "ID is required", "400");
            }

            Optional<CommentsDTO> comment = commentsRepository.findById(id)
                    .map(Utils::convertToCommentsDTO);

            return comment.map(c -> buildResponse(List.of(c), "Fetch successful", "200"))
                    .orElseGet(() -> buildResponse(Collections.emptyList(), "Comment not found", "200"));
        } catch (Exception e) {
            throw new RuntimeException("Unable to find comment by ID: " + e.getMessage(), e);
        }
    }

    public CommentsDTO.ResponseCommentsDTO fetchCommentsByEmail(String email) {
        try {
            if (email == null || email.isEmpty()) {
                return buildResponse(Collections.emptyList(), "Email is required", "400");
            }

            List<CommentsDTO> commentsList = commentsRepository.findByEmail(email).stream()
                    .map(Utils::convertToCommentsDTO)
                    .collect(Collectors.toList());

            String message = commentsList.isEmpty() ? "Comment not found" : "Fetch successful";
            return buildResponse(commentsList, message, "200");
        } catch (Exception e) {
            throw new RuntimeException("Unable to find comments by email: " + e.getMessage(), e);
        }
    }

    private CommentsDTO.ResponseCommentsDTO buildResponse(List<CommentsDTO> commentsList, String message, String status) {
        CommentsDTO.ResponseCommentsDTO response = new CommentsDTO.ResponseCommentsDTO();
        response.setComments(commentsList);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}

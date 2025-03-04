package com.example.spring.App.model.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsDTO {
    private String id;
    private String name;
    private String email;
    private String movie_id;
    private String text;
    private String date;

    @Getter
    @Setter
    public static class ResponseCommentsDTO {
        private List<CommentsDTO> comments;
        private String status;
        private String message;
    }
}

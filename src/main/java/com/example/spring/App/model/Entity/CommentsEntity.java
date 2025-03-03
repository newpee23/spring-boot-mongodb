package com.example.spring.App.model.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "comments")
public class CommentsEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String movie_id; // ✅ ใช้ ObjectId แทน String
    private String text;
    private String date;
}

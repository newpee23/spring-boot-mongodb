package com.example.spring.App.model.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "users")
public class UsersEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

}


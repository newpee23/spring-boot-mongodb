package com.example.spring.App.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StatusOk {

    public static ResponseEntity<Object> Response(Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}

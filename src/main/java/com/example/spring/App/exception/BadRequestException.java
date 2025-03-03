package com.example.spring.App.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.spring.App.model.DTO.ErrorResponseDTO;

public class BadRequestException {

    public static ResponseEntity<Object> BadRequest(String message) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error: " + message, "400");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

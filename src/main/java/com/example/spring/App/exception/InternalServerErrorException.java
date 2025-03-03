package com.example.spring.App.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.spring.App.model.DTO.ErrorResponseDTO;

public class InternalServerErrorException {

    public static ResponseEntity<Object> InternalServerError(String message) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Error: " + message, "500");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

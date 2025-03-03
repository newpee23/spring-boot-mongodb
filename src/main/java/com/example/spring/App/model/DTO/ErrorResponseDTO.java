package com.example.spring.App.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
    private String message;
    private String status;

    public ErrorResponseDTO(String message, String status) {
        this.message = message;
        this.status = status;
    }
}

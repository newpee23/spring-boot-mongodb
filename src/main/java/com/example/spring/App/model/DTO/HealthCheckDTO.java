package com.example.spring.App.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthCheckDTO {
    private String status;
    private String message;
}

package com.example.spring.App.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.App.exception.StatusOk;
import com.example.spring.App.model.DTO.HealthCheckDTO;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/healthCheck")
    public ResponseEntity<Object> healthCheck() {
        HealthCheckDTO jsonResponse = new HealthCheckDTO();
        jsonResponse.setStatus("200");
        jsonResponse.setMessage("Service is running");
        
        return StatusOk.Response(jsonResponse);
    }
}

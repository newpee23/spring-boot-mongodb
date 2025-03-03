package com.example.spring.App.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.App.exception.BadRequestException;
import com.example.spring.App.exception.InternalServerErrorException;
import com.example.spring.App.exception.StatusOk;
import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllUserList() {
        try {
            UserDTO.ResponseUserDTO users = userService.getAllUsers();
            return StatusOk.Response(users);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUserById(@RequestParam String id) {
        try {
            UserDTO.ResponseUserDTO user = userService.getUserById(id);
            
            if (user.getStatus().equals("400")) {
                return BadRequestException.BadRequest("ID is required");
            }
            return StatusOk.Response(user);
        } catch (Exception e) {
            return InternalServerErrorException.InternalServerError(e.getMessage());
        }
    }
}

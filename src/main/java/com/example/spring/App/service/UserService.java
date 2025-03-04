package com.example.spring.App.service;

import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.model.Entity.UsersEntity;
import com.example.spring.App.repository.UserRepository;
import com.example.spring.App.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO.ResponseUserDTO fetchAllUsers() {
        try {
            List<UserDTO> users = userRepository.findAll().stream()
                    .map(Utils::convertToDTO)
                    .collect(Collectors.toList());

            if (users.isEmpty()) {
                return buildUserResponse(Collections.emptyList(), "No users found", "200");
            }

            return buildUserResponse(users, "Fetch successful", "200");
        } catch (Exception e) {
            throw new RuntimeException("Unable to retrieve users: " + e.getMessage(), e);
        }
    }

    public UserDTO.ResponseUserDTO fetchUserById(String id) {
        try {
            if (id == null || id.isEmpty()) {
                return buildUserResponse(Collections.emptyList(), "User ID is required", "400");
            }

            Optional<UsersEntity> userEntity = userRepository.findById(id);

            if (userEntity.isEmpty()) {
                return buildUserResponse(Collections.emptyList(), "User not found", "200");
            }

            List<UserDTO> user = List.of(Utils.convertToDTO(userEntity.get()));
            return buildUserResponse(user, "Fetch successful", "200");

        } catch (Exception e) {
            throw new RuntimeException("Unable to find user by ID: " + e.getMessage(), e);
        }
    }

    public UserDTO.ResponseUserDTO addUser(UserDTO userDTO) {
        try {
       
            UsersEntity userEntity = new UsersEntity();
            userEntity.setName(userDTO.getName());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setPassword(userDTO.getPassword()); // Ensure to handle passwords securely in a real-world scenario

            UsersEntity savedUserEntity = userRepository.save(userEntity);

            UserDTO savedUserDTO = Utils.convertToDTO(savedUserEntity);
            return buildUserResponse(List.of(savedUserDTO), "User added successfully", "201");
        } catch (Exception e) {
            throw new RuntimeException("Unable to add user: " + e.getMessage(), e);
        }
    }

    public UserDTO.ResponseUserDTO buildUserResponse(List<UserDTO> users, String message, String status) {
        UserDTO.ResponseUserDTO response = new UserDTO.ResponseUserDTO();
        response.setUserDTO(users);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}
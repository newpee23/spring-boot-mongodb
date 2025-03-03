package com.example.spring.App.service;

import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.model.Entity.UsersEntity;
import com.example.spring.App.repository.UserRepository;
import com.example.spring.App.utils.Utils; // ✅ Import Utils

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

    public UserDTO.ResponseUserDTO getAllUsers() {
        try {
            // ✅ เรียก Utils แบบ static
            List<UserDTO> userDTOList = userRepository.findAll().stream()
                    .map(Utils::convertToDTO)
                    .collect(Collectors.toList());

            return userDTOList.isEmpty()
                    ? Utils.getUserResponse(Collections.emptyList(), "User not found", "200")
                    : Utils.getUserResponse(userDTOList, "Successfully", "200");
        } catch (Exception e) {
            throw new RuntimeException("ไม่สามารถดึงข้อมูลผู้ใช้ได้: " + e.getMessage(), e);
        }
    }

    public UserDTO.ResponseUserDTO getUserById(String id) {
        try {
            if (id == null || id.isEmpty()) {
                return Utils.getUserResponse(Collections.emptyList(), "ID is required", "400");
            }

            Optional<UsersEntity> userOptional = userRepository.findById(id);

            if (userOptional.isEmpty()) {
                return Utils.getUserResponse(Collections.emptyList(), "User not found", "200");
            }

            List<UserDTO> userList = List.of(Utils.convertToDTO(userOptional.get()));
            return Utils.getUserResponse(userList, "Successfully", "200");

        } catch (Exception e) {
            throw new RuntimeException("ไม่สามารถค้นหาผู้ใช้โดย ID: " + e.getMessage(), e);
        }
    }
}

package com.example.spring.App.utils;

import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.model.Entity.UsersEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass // ✅ Lombok จะทำให้ทุกเมธอดในคลาสนี้เป็น static โดยอัตโนมัติ
public class Utils {

    public UserDTO convertToDTO(UsersEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public UserDTO.ResponseUserDTO getUserResponse(List<UserDTO> userDTOList, String message, String status) {
        UserDTO.ResponseUserDTO response = new UserDTO.ResponseUserDTO();
        response.setUserDTO(userDTOList);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}

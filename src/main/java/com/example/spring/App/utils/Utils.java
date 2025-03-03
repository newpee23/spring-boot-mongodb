package com.example.spring.App.utils;

import com.example.spring.App.model.DTO.CommetsDTO;
import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.model.Entity.CommentsEntity;
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

    public CommetsDTO convertToCommetsDTO(CommentsEntity comment) { 
        CommetsDTO commetDTO = new CommetsDTO();
        commetDTO.setId(comment.getId()); // ✅ แปลง ObjectId เป็น String
        commetDTO.setName(comment.getName());
        commetDTO.setEmail(comment.getEmail());
        commetDTO.setMovie_id(comment.getMovie_id() != null ? comment.getMovie_id() : null); // ✅ ป้องกัน NPE
        commetDTO.setText(comment.getText());
        commetDTO.setDate(comment.getDate());
        return commetDTO;
    }
    

    public UserDTO.ResponseUserDTO getUserResponse(List<UserDTO> userDTOList, String message, String status) {
        UserDTO.ResponseUserDTO response = new UserDTO.ResponseUserDTO();
        response.setUserDTO(userDTOList);
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}

package com.example.spring.App.utils;

import com.example.spring.App.model.DTO.CommentsDTO;
import com.example.spring.App.model.DTO.UserDTO;
import com.example.spring.App.model.Entity.CommentsEntity;
import com.example.spring.App.model.Entity.UsersEntity;
import lombok.experimental.UtilityClass;

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

    public CommentsDTO convertToCommentsDTO(CommentsEntity comment) { 
        CommentsDTO commetDTO = new CommentsDTO();
        commetDTO.setId(comment.getId()); // ✅ แปลง ObjectId เป็น String
        commetDTO.setName(comment.getName());
        commetDTO.setEmail(comment.getEmail());
        commetDTO.setMovie_id(comment.getMovie_id() != null ? comment.getMovie_id() : null); // ✅ ป้องกัน NPE
        commetDTO.setText(comment.getText());
        commetDTO.setDate(comment.getDate());
        return commetDTO;
    }
}

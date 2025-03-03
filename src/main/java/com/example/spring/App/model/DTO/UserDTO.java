package com.example.spring.App.model.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String password;

    // ✅ Nested Class - UserDTO (อยู่ใน ResponseUserDTO)
    @Getter
    @Setter
    public static class ResponseUserDTO {
        private List<UserDTO> userDTO;
        private String message;
        private String status;
    }
}

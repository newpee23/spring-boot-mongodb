package com.example.spring.App.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.spring.App.utils.Utils;
import com.example.spring.App.model.DTO.CommetsDTO;
import com.example.spring.App.repository.CommentsRepository;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public List<CommetsDTO> getAllComments() { // ✅ เปลี่ยนชื่อให้สื่อความหมาย
        try {
            return commentsRepository.findAll().stream()
                    .map(Utils::convertToCommetsDTO) // ✅ ใช้ Utils แปลงจาก Entity -> DTO
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("ไม่สามารถดึงข้อมูลคอมเมนต์ได้: " + e.getMessage(), e);
        }
    }
}

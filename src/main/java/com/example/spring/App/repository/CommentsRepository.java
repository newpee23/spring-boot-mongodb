package com.example.spring.App.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.spring.App.model.Entity.CommentsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends MongoRepository<CommentsEntity, String> {

    // ค้นหาคอมเมนต์จาก email (String)
    Optional<CommentsEntity> findByEmail(String email);

    // ค้นหาผู้ใช้ทั้งหมด
    List<CommentsEntity> findAll();
}

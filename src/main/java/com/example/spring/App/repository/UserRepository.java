package com.example.spring.App.repository;

import java.util.List;
import java.util.Optional;

import com.example.spring.App.model.Entity.UsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UsersEntity, String> {

    // ค้นหาผู้ใช้โดย ID
    Optional<UsersEntity> findById(String id);

    // ค้นหาผู้ใช้ทั้งหมด
    List<UsersEntity> findAll();

    // ค้นหาผู้ใช้โดย Email
    Optional<UsersEntity> findByEmail(String email);

    // ค้นหาผู้ใช้โดย Email และ Password
    Optional<UsersEntity> findByEmailAndPassword(String email, String password);

    // ค้นหาผู้ใช้โดย Name
    List<UsersEntity> findByName(String name);

    // ค้นหาผู้ใช้โดย Name และ Password
    Optional<UsersEntity> findByNameAndPassword(String name, String password);

    // ลบผู้ใช้ตาม ID
    void deleteById(String id);

    // save: บันทึก (insert หรือ update) ข้อมูล
    <S extends UsersEntity> S save(S entity);  // MongoRepository มีให้แล้ว

    // ตัวอย่างการค้นหาโดยใช้ findAllBy และคำสั่งพิเศษ
    List<UsersEntity> findAllByNameContainingIgnoreCase(String name);
}

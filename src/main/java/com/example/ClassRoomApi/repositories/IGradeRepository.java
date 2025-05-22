package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Integer> {
}

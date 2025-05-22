package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
}

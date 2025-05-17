package com.example.ClassRoomApi.repositories;

import com.example.ClassRoomApi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {

}

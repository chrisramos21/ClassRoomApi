package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Student;
import com.example.ClassRoomApi.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepository repository;

    // GUARDAR
    public Student saveStudent(Student dataStudent) throws Exception {
        try {
            return this.repository.save(dataStudent);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // MODIFICAR
    public Student modifyStudent(Integer id, Student dataStudent) throws Exception {
        try {
            Optional<Student> searchedStudent = this.repository.findById(id);
            if (searchedStudent.isPresent()) {
                searchedStudent.get().setGradeLevel(dataStudent.getGradeLevel());
                searchedStudent.get().setBirthDate(dataStudent.getBirthDate());
                searchedStudent.get().setAddress(dataStudent.getAddress());
                return this.repository.save(searchedStudent.get());
            } else {
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // BUSCAR POR ID
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> searchedStudent = this.repository.findById(id);
            if (searchedStudent.isPresent()) {
                return searchedStudent.get();
            } else {
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<Student> searchAllStudents() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // ELIMINAR
    public boolean deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> searchedStudent = this.repository.findById(id);
            if (searchedStudent.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }
}

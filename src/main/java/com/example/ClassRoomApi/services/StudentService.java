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
    @Autowired //Inyección de dependencias
    IStudentRepository repository;

    //GUARDAR
    public Student saveStudent(Student dataStudent)throws Exception{
        try{
            return this.repository.save(dataStudent);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //MODIFICAR
    public Student modifyStudent(Integer id, Student dataStudent)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Student> searchedStudent = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedStudent.isPresent()){
                //Modifiquelo pues papá
                searchedStudent.get().setGradeLevel(dataStudent.getGradeLevel());
                searchedStudent.get().setBirthDate(dataStudent.getBirthDate());
                searchedStudent.get().setAddress(dataStudent.getAddress());
                return this.repository.save(searchedStudent.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR POR ID
    public Student searchStudentById(Integer id)throws Exception{
        try{
            Optional<Student> searchedStudent = this.repository.findById(id);
            if (searchedStudent.isPresent()){
                //Retorno el docente que busco
                return searchedStudent.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Student> searchAllStudent()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteStudent(Integer id)throws Exception{
        try{
            Optional<Student> searchedStudent = this.repository.findById(id);
            if (searchedStudent.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.STUDENT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
}

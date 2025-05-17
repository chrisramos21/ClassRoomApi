package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Course;
import com.example.ClassRoomApi.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired //inyección de dependecias
    ICourseRepository repository;

    //Guardar
    public Course saveCourse(Course dataCourse)throws  Exception{
        try{
            return this.repository.save(dataCourse);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //Modificar
    public Course modifyCourse(Integer id, Course dataCourse)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Course> searchedCourse = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedCourse.isPresent()){
                //Modifiquelo pues papá
                searchedCourse.get().setName(dataCourse.getName());
                return this.repository.save(searchedCourse.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.COURSE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //BUSCAR POR ID
    public Course searchCourseById(Integer id)throws Exception{
        try{
            Optional<Course> searchedCourse = this.repository.findById(id);
            if (searchedCourse.isPresent()){
                //Retorno el curso que busco
                return searchedCourse.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.COURSE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Course> searchAllCourse()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteCourse(Integer id)throws Exception{
        try{
            Optional<Course> searchedCourse = this.repository.findById(id);
            if (searchedCourse.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.COURSE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }



}

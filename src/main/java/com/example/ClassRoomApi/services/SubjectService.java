package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Subject;
import com.example.ClassRoomApi.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired //inyección de dependecias
    ISubjectRepository repository;

    //Guardar
    public Subject saveSubject(Subject dataSubject)throws  Exception{
        try{
            return this.repository.save(dataSubject);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //Modificar
    public Subject modifySubject(Integer id, Subject dataSubject)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Subject> searchedSubject = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedSubject.isPresent()){
                //Modifiquelo pues papá
                searchedSubject.get().setName(dataSubject.getName());
                return this.repository.save(searchedSubject.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.SUBJECT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR POR ID
    public Subject searchSubjectById(Integer id)throws Exception{
        try{
            Optional<Subject> searchedSubject = this.repository.findById(id);
            if (searchedSubject.isPresent()){
                //Retorno el curso que busco
                return searchedSubject.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.SUBJECT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Subject> searchAllSubject()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteSubject(Integer id)throws Exception{
        try{
            Optional<Subject> searchedSubject = this.repository.findById(id);
            if (searchedSubject.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.SUBJECT_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
}

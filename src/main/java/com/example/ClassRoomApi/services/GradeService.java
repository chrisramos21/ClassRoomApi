package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Grade;
import com.example.ClassRoomApi.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired //inyección de dependecias
    IGradeRepository repository;

    //Guardar
    public Grade saveGrade(Grade dataGrade)throws  Exception{
        try{
            return this.repository.save(dataGrade);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //Modificar
    public Grade modifyGrade(Integer id, Grade dataGrade)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Grade> searchedGrade = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedGrade.isPresent()){
                //Modifiquelo pues papá
                searchedGrade.get().setGrade(dataGrade.getGrade());
                searchedGrade.get().setTestDate(dataGrade.getTestDate());
                return this.repository.save(searchedGrade.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.GRADE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //BUSCAR POR ID
    public Grade searchGradeById(Integer id)throws Exception{
        try{
            Optional<Grade> searchedGrade = this.repository.findById(id);
            if (searchedGrade.isPresent()){
                //Retorno el curso que busco
                return searchedGrade.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.GRADE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Grade> searchAllGrade()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteGrade(Integer id)throws Exception{
        try{
            Optional<Grade> searchedGrade = this.repository.findById(id);
            if (searchedGrade.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.GRADE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
}

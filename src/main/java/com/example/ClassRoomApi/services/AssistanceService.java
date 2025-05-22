package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Assistance;
import com.example.ClassRoomApi.repositories.IAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistanceService {

    @Autowired //inyección de dependecias
    IAssistanceRepository repository;

    //Guardar
    public Assistance saveAssistance(Assistance dataAssistance)throws  Exception{
        try{
            return this.repository.save(dataAssistance);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //Modificar
    public Assistance modifyAssistance(Integer id, Assistance dataAssistance)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Assistance> searchedAssistance = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedAssistance.isPresent()){
                //Modifiquelo pues papá
                searchedAssistance.get().setDate(dataAssistance.getDate());
                searchedAssistance.get().setStatus(dataAssistance.getStatus());
                return this.repository.save(searchedAssistance.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.ASSISTANCE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR POR ID
    public Assistance searchAssistanceById(Integer id)throws Exception{
        try{
            Optional<Assistance> searchedAssistance = this.repository.findById(id);
            if (searchedAssistance.isPresent()){
                //Retorno el curso que busco
                return searchedAssistance.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.ASSISTANCE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Assistance> searchAllAssistance()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteAssistance(Integer id)throws Exception{
        try{
            Optional<Assistance> searchedAssistance = this.repository.findById(id);
            if (searchedAssistance.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.ASSISTANCE_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
}


package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.Course;
import com.example.ClassRoomApi.models.Inscription;
import com.example.ClassRoomApi.repositories.IInscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired //inyección de dependecias
    IInscriptionRepository repository;

    //Guardar
    public Inscription saveInscription(Inscription dataInscription)throws  Exception{
        try{
            return this.repository.save(dataInscription);
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //Modificar
    public Inscription modifyInscription(Integer id, Inscription dataInscription)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<Inscription> searchedInscription = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedInscription.isPresent()){
                //Modifiquelo pues papá
                searchedInscription.get().setInscriptionDate(dataInscription.getInscriptionDate());
                return this.repository.save(searchedInscription.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.INSCRIPTION_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //BUSCAR POR ID
    public Inscription searchInscriptionById(Integer id)throws Exception{
        try{
            Optional<Inscription> searchedInscription = this.repository.findById(id);
            if (searchedInscription.isPresent()){
                //Retorno el curso que busco
                return searchedInscription.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.INSCRIPTION_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<Inscription> searchAllInscription()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //ELIMINAR
    public boolean deleteInscription(Integer id)throws Exception{
        try{
            Optional<Inscription> searchedInscription = this.repository.findById(id);
            if (searchedInscription.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.INSCRIPTION_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }


}

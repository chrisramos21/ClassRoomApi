package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.DTO.DTOUser;
import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.maps.IUserMap;
import com.example.ClassRoomApi.models.User;
import com.example.ClassRoomApi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //inyección de dependecias
    IUserRepository repository;

    //Inyectar el mapa

    @Autowired
    IUserMap IUserMap;

    //Guardar
    public DTOUser saveUser(User dataUser)throws  Exception{
        try{
            return this.IUserMap.transformModelDTO(this.repository.save(dataUser));
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }

    //Modificar
    public User modifyUser(Integer id, User dataUser)throws Exception{
        try {
            //Para modificar primero debo buscar
            //JPA me devuelve un dato opcional (puede estar o no)
            Optional<User> searchedUser = this.repository.findById(id);
            //Apenas lo busqués pregunta si si está
            if(searchedUser.isPresent()){
                //Modifiquelo pues papá
                searchedUser.get().setEmail(dataUser.getEmail());
                searchedUser.get().setName(dataUser.getName());
                searchedUser.get().setPassword(dataUser.getPassword());
                searchedUser.get().setPhoneNumber(dataUser.getPhoneNumber());
                searchedUser.get().setUserType(dataUser.getUserType());
                return this.repository.save(searchedUser.get());
            }else{
                //No estaba el muñeco
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR POR ID
    public User searchUserById(Integer id)throws Exception{
        try{
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()){
                //Retorno el Usuario que busco
                return searchedUser.get();
            }else{
                //Mensaje que no está
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //BUSCAR TODOS
    public List<User> searchAllUser()throws Exception{
        try{
            return this.repository.findAll();
        }catch(Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }
    //ELIMINAR
    public boolean deleteUser(Integer id)throws Exception{
        try{
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        }catch (Exception mistake){
            throw new Exception(mistake.getMessage());
        }
    }


}



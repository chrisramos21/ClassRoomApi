package com.example.ClassRoomApi.services;

import com.example.ClassRoomApi.helpers.ApiMessage;
import com.example.ClassRoomApi.models.User;
import com.example.ClassRoomApi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    // GUARDAR
    public User saveUser(User dataUser) throws Exception {
        try {
            return this.repository.save(dataUser);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // MODIFICAR
    public User modifyUser(Integer id, User dataUser) throws Exception {
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()) {
                searchedUser.get().setEmail(dataUser.getEmail());
                searchedUser.get().setName(dataUser.getName());
                searchedUser.get().setPassword(dataUser.getPassword());
                searchedUser.get().setPhoneNumber(dataUser.getPhoneNumber());
                searchedUser.get().setUserType(dataUser.getUserType());
                return this.repository.save(searchedUser.get());
            } else {
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // BUSCAR POR ID
    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()) {
                return searchedUser.get();
            } else {
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<User> searchAllUsers() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // ELIMINAR
    public boolean deleteUser(Integer id) throws Exception {
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.USER_NOT_FOUND.getText());
            }
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }
}



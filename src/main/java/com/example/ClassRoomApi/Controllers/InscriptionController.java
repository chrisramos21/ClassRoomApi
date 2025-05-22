package com.example.ClassRoomApi.Controllers;

import com.example.ClassRoomApi.models.Inscription;
import com.example.ClassRoomApi.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {
    @Autowired
    InscriptionService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> keep(@RequestBody Inscription dataSentByClient){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveInscription(dataSentByClient));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Inscription data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.modifyInscription(id, data));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchInscriptionById(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAllInscription());
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteInscription(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }



}

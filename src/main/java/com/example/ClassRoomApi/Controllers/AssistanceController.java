package com.example.ClassRoomApi.Controllers;

import com.example.ClassRoomApi.models.Assistance;
import com.example.ClassRoomApi.services.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistances")
public class AssistanceController {
    @Autowired
    AssistanceService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> keep(@RequestBody Assistance dataSentByClient){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveAssistance(dataSentByClient));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Assistance data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.modifyAssistance(id, data));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAssistanceById(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAllAssistance());
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteAssistance(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }
}

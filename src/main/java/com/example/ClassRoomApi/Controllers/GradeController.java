package com.example.ClassRoomApi.Controllers;

import com.example.ClassRoomApi.models.Grade;
import com.example.ClassRoomApi.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradeController {
    @Autowired
    GradeService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> keep(@RequestBody Grade dataSentByClient){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveGrade(dataSentByClient));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Grade data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.modifyGrade(id, data));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchGradeById(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAllGrade());
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteGrade(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }



}

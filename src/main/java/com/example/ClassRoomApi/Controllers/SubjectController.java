package com.example.ClassRoomApi.Controllers;

import com.example.ClassRoomApi.models.Subject;
import com.example.ClassRoomApi.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    SubjectService service;

    //Controlador para guardar
    @PostMapping
    public ResponseEntity<?> keep(@RequestBody Subject dataSentByClient){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveSubject(dataSentByClient));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Subject data){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.modifySubject(id, data));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

    //Controlador para buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchSubjectById(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }
    }

    //Controlador para buscarlos todos
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.searchAllSubject());
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }
    //Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.service.deleteSubject(id));
        }catch (Exception mistakeAPI){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mistakeAPI.getMessage());
        }

    }

}

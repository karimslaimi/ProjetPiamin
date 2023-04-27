package com.esprit.projetpi.Controllers;

import com.esprit.projetpi.Entities.Candidature;
import com.esprit.projetpi.Services.IServiceCandidature;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("candidature")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidatureController {
    private IServiceCandidature serviceCandidature;

    public CandidatureController(IServiceCandidature service){
        this.serviceCandidature=service;
    }



    @Operation(summary = "create application",description = "create candidature ")
    @PostMapping("create")
    public ResponseEntity<?> createCandidature(@RequestBody Candidature candidate){



        Candidature c=serviceCandidature.postC(candidate);
        if(c!=null){
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("error occured",HttpStatus.BAD_REQUEST);
        }
    }




    @Operation(summary = "all applications",description = "get the list of all applications")
    @GetMapping("/all")
    public ResponseEntity<?> allCandidature(){
        return new ResponseEntity<>(serviceCandidature.allCandidature(),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "delete candidature",description = "delete application")
    @DeleteMapping("/deletec/{id}")
     public ResponseEntity<?> deleteCandidature(@PathVariable("id") int id){
        if (id != 0){
            serviceCandidature.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("error not found", HttpStatus.BAD_REQUEST);
     }
}

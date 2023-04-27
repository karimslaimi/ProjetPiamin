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


    @Operation(summary = "filter by state",description = "filter the applications by the state of application (accepted/refused/on hold)")
    @GetMapping("/filter")
    public ResponseEntity<?> filterByState(@RequestParam(name="filter")String filter){
        return new ResponseEntity<>(serviceCandidature.filterByState(filter),HttpStatus.OK);
    }



    @Operation(summary = "update application's state",description = "update an application state relative to the id make it accepted/refused or on hold ")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCandidate(@RequestParam(name="state")String state,@PathVariable int id){
        Candidature c=serviceCandidature.updateCandidate(id,state);
        if(c==null){
            return new ResponseEntity<>("error occured",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
    }
}

package com.r2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2.api.modeles.Intervention;
import com.r2.api.service.InterventionService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/intervention")
@AllArgsConstructor
public class InterventionController {
    InterventionService interventionService;

    //Creates a new inventaire
    @PostMapping("/create")
    public ResponseEntity<Intervention> create(@RequestBody Intervention intervention){
        try {
            System.out.println(intervention.toString());
            Intervention createdDetails = interventionService.postIntervention(intervention);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all Inventaire
    @GetMapping("/read")
    public ResponseEntity<List<Intervention>> read() {
        try{
        List<Intervention> lstf=interventionService.getIntervention();
        System.out.println(lstf);
        return new ResponseEntity<>(interventionService.getIntervention(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing Inventaire
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
    try {
        interventionService.deleteIntervention(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "intervention supprimé");
    return ResponseEntity.ok(response);
}
/* 
@GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Integer id) {
        Intervention intervention = interventionService.getInterventionById(id);
        if (intervention != null) {
            return ResponseEntity.ok(intervention);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}

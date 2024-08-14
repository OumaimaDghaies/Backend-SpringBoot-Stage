package com.r2.api.controller;

import lombok.AllArgsConstructor;

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

import com.r2.api.modeles.Immobilisation;
import com.r2.api.service.ImmobilisationService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/immobilisation")
@AllArgsConstructor
public class ImmobilisationController {
    ImmobilisationService immobilisationService;


    //Creates a new immobilisation
    @PostMapping("/create")
    public ResponseEntity<Immobilisation> create(@RequestBody Immobilisation immobilisation){
        try {
            Immobilisation createdDetails = immobilisationService.postImmobilisation(immobilisation);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all immobilisation
    @GetMapping("/read")
    public ResponseEntity<List<Immobilisation>> read() {
        try{
        List<Immobilisation> lstf=immobilisationService.getImmobilisation();
        System.out.println(lstf);
        return new ResponseEntity<>(immobilisationService.getImmobilisation(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing immobilisation
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        immobilisationService.deleteImmobilisation(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Immobilisation supprimé");
    return ResponseEntity.ok(response);
}

}

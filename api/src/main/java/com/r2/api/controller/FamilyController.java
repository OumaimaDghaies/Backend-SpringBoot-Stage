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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2.api.modeles.Famille;
import com.r2.api.service.FamilyService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familles")
@AllArgsConstructor
public class FamilyController {
    FamilyService familyService;

    //Creates a new family
    @PostMapping("/create")
    public ResponseEntity<Famille> create(@RequestBody Famille famille) {
        try {
            System.out.println(famille.toString());
            Famille createdFamille = familyService.postFamily(famille);
            return new ResponseEntity<>(createdFamille, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Retrieves all families
    @GetMapping("/read")
    public ResponseEntity<List<Famille>> read() {
        try{
        List<Famille> lstf=familyService.getFamily();
        System.out.println(lstf);
        return new ResponseEntity<>(familyService.getFamily(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Updates an existing family
    @PutMapping("/update/{id}")
    public ResponseEntity<Famille> update(@PathVariable Integer id, @RequestBody Famille famille) {
        try {
            Famille updatedFamille = familyService.putFamily(id, famille);
            return new ResponseEntity<>(updatedFamille, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Deletes an existing family
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
    try {
        familyService.deleteFamily(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Famille Produit Fini supprimé");
    return ResponseEntity.ok(response);
}

}

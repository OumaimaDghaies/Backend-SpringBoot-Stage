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

import com.r2.api.modeles.Panne;
import com.r2.api.service.PanneService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pannes")
@AllArgsConstructor

public class PanneController {

    PanneService panneService;
    // Create a new panne
    @PostMapping("/create")
    public ResponseEntity<Panne> createPanne(@RequestBody Panne panne) {
        try {

            Panne createdProduitFini = panneService.postPanne(panne);
            return new ResponseEntity<>(createdProduitFini, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all panne
    @GetMapping("/read")
    public ResponseEntity<List<Panne>> read() {
        try{
        List<Panne> lstf=panneService.getPanne();
        System.out.println(lstf);
        return new ResponseEntity<>(panneService.getPanne(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing panne
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
    try {
        panneService.deletePanne(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Panne supprimé");
    return ResponseEntity.ok(response);
}


}

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

import com.r2.api.modeles.Preparation;
import com.r2.api.service.PreparationService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/preparation")
@AllArgsConstructor
public class PreparationController {
    PreparationService preparationService;


    //Creates a new preparation
    @PostMapping("/create")
    public ResponseEntity<Preparation> create(@RequestBody Preparation preparation){
        try {
            Preparation createdDetails = preparationService.postPreparation(preparation);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all preparation
    @GetMapping("/read")
    public ResponseEntity<List<Preparation>> read() {
        try{
        List<Preparation> lstf=preparationService.getPreparation();
        System.out.println(lstf);
        return new ResponseEntity<>(preparationService.getPreparation(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing preparation
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        preparationService.deletePreparation(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Preparation supprimé");
    return ResponseEntity.ok(response);
}

}

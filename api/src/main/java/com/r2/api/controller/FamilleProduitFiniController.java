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

import com.r2.api.modeles.FamilleProduitFini;
import com.r2.api.service.FamilleProduitFiniService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familleProduitFini")
@AllArgsConstructor
public class FamilleProduitFiniController {
    FamilleProduitFiniService familleProduitFiniService;


    //Creates a new Family Product
    @PostMapping("/create")
    public ResponseEntity<FamilleProduitFini> create(@RequestBody FamilleProduitFini familleProduitFini){
        try {
            FamilleProduitFini createdDetails = familleProduitFiniService.postFamilyProduct(familleProduitFini);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all gamme
    @GetMapping("/read")
    public ResponseEntity<List<FamilleProduitFini>> read() {
        try{
        List<FamilleProduitFini> lstf=familleProduitFiniService.getFamilyProduct();
        System.out.println(lstf);
        return new ResponseEntity<>(familleProduitFiniService.getFamilyProduct(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing gamme
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
    try {
        familleProduitFiniService.deleteFamilyProduct(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Famille Produit Fini supprimé");
    return ResponseEntity.ok(response);
}

}

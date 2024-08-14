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

import com.r2.api.modeles.ProduitFini;
import com.r2.api.service.FamilleProduitFiniService;
import com.r2.api.service.GammeService;
import com.r2.api.service.ProduitFiniService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produitFinis")
@AllArgsConstructor
public class ProduitFiniController {
    ProduitFiniService produitFiniService;
    GammeService gammeService;
    FamilleProduitFiniService familleProduitFiniService;


 
    // Create a new ProduitFini
    @PostMapping("/create")
    public ResponseEntity<ProduitFini> createProduitFini(@RequestBody ProduitFini produitFini) {
        try {

            ProduitFini createdProduitFini = produitFiniService.postProductF(produitFini);
            return new ResponseEntity<>(createdProduitFini, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all produitFini
    @GetMapping("/read")
    public ResponseEntity<List<ProduitFini>> read() {
        try{
        List<ProduitFini> lstf=produitFiniService.getProductF();
        System.out.println(lstf);
        return new ResponseEntity<>(produitFiniService.getProductF(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing produitFini
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
    try {
        produitFiniService.deleteProductF(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Produit fini supprimé");
    return ResponseEntity.ok(response);
}

}

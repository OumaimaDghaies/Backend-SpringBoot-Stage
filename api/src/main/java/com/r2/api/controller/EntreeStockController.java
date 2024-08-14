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

import com.r2.api.modeles.EntreeStock;
import com.r2.api.service.EntreeStockService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/entreestock")
@AllArgsConstructor
public class EntreeStockController {

    EntreeStockService entreeStockService;

    //Creates a new stock-entry
    @PostMapping("/create")
    public ResponseEntity<EntreeStock> create(@RequestBody EntreeStock entreeStock) {
        try {
            EntreeStock createdEntreeStock = entreeStockService.postStockEntry(entreeStock);
            return new ResponseEntity<>(createdEntreeStock, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all stock-entry
    @GetMapping("/read")
    public ResponseEntity<List<EntreeStock>> read() {
        try{
        List<EntreeStock> lstf=entreeStockService.getStockEntry();
        System.out.println(lstf);
        return new ResponseEntity<>(entreeStockService.getStockEntry(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Deletes an existing family
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        entreeStockService.deleteStockEntry(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Stock supprimé");
    return ResponseEntity.ok(response);
}

}

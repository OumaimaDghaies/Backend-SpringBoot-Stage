package com.r2.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r2.api.modeles.DetailsEntreeStock;
import com.r2.api.service.DetailsEntreeStockService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/detailsentreestock")
@AllArgsConstructor
public class DetailsEntreeStockController {
    DetailsEntreeStockService detailsEntreeStockService;

    //Creates a new stock entry details
    @PostMapping("/create")
    public ResponseEntity<DetailsEntreeStock> create(@RequestBody DetailsEntreeStock detailsEntreeStock){
        try {
            DetailsEntreeStock createdDetails = detailsEntreeStockService.postStockEntryDetails(detailsEntreeStock);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all stock entry details
    @GetMapping("/read")
    public ResponseEntity<List<DetailsEntreeStock>> read() {
        try{
        List<DetailsEntreeStock> lstf=detailsEntreeStockService.getStockEntryDetails();
        System.out.println(lstf);
        return new ResponseEntity<>(detailsEntreeStockService.getStockEntryDetails(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

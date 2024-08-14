package com.r2.api.controller;


import java.util.List;

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


import com.r2.api.modeles.SousFamille;
import com.r2.api.service.SousFamilyService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sousfamilles")
@AllArgsConstructor
public class SousFamilyController {
    SousFamilyService sousfamilyService;

    //Creates a new sub-family
    @PostMapping("/create")
    public ResponseEntity<SousFamille> create(@RequestBody SousFamille sousfamille){
        try {
            return new ResponseEntity<>(sousfamilyService.postSubFamily(sousfamille),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all sub-families
    @GetMapping("/read")
    public ResponseEntity<List<SousFamille>> read() {
        try{
        List<SousFamille> lstf=sousfamilyService.getSubFamily();
        System.out.println(lstf);
        return new ResponseEntity<>(sousfamilyService.getSubFamily(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Updates an existing sub-family
    @PutMapping("/update/{idsousfamille}")
    public ResponseEntity<SousFamille> update(@PathVariable Integer idsousfamille, @RequestBody SousFamille sousfamille){
        try{
        return new ResponseEntity<>(sousfamilyService.putSubFamily(idsousfamille, sousfamille),HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    //Deletes an existing family
    @DeleteMapping("/delete/{idsousfamille}")
    public ResponseEntity<String>  delete(@PathVariable Integer idsousfamille){
        try {
            return new ResponseEntity<>(sousfamilyService.deleteSubFamily(idsousfamille), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }


}

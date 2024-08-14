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

import com.r2.api.modeles.TypeMateriel;
import com.r2.api.service.TypeMaterielService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typemateriel")
@AllArgsConstructor
public class TypeMaterielController {

    TypeMaterielService typeMaterielService;

    //Creates a new TypeMateriel
      @PostMapping("/create")
    public ResponseEntity<TypeMateriel> create(@RequestBody TypeMateriel typemateriel){
        try {
            TypeMateriel createdDetails = typeMaterielService.postTypeMateriel(typemateriel);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all TypeMateriel
    @GetMapping("/read")
    public ResponseEntity<List<TypeMateriel>> read() {
        try{
        List<TypeMateriel> lstf=typeMaterielService.getTypeMateriel();
        System.out.println(lstf);
        return new ResponseEntity<>(typeMaterielService.getTypeMateriel(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing TypeMateriel
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        typeMaterielService.deleteTypeMateriel(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Type Materiel supprimé");
    return ResponseEntity.ok(response);
}


}

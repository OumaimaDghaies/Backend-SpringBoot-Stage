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

import com.r2.api.modeles.TypePanne;
import com.r2.api.service.TypePanneService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typepanne")
@AllArgsConstructor
public class TypePanneController {
    TypePanneService typepanneService;


    //Creates a new typepanne
    @PostMapping("/create")
    public ResponseEntity<TypePanne> create(@RequestBody TypePanne typepanne){
        try {
            TypePanne createdDetails = typepanneService.postTypePanne(typepanne);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all typepanne
    @GetMapping("/read")
    public ResponseEntity<List<TypePanne>> read() {
        try{
        List<TypePanne> lstf=typepanneService.getTypePanne();
        System.out.println(lstf);
        return new ResponseEntity<>(typepanneService.getTypePanne(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing typepanne
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        typepanneService.deleteTypePanne(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Type de panne supprimé");
    return ResponseEntity.ok(response);
}

}

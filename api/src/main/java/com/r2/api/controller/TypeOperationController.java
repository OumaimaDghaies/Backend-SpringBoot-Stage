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

import com.r2.api.modeles.TypeOperation;
import com.r2.api.service.TypeOperationService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/typeoperation")
@AllArgsConstructor
public class TypeOperationController {
    TypeOperationService typeOperationService;

    //Creates a new TypeOperation
      @PostMapping("/create")
    public ResponseEntity<TypeOperation> create(@RequestBody TypeOperation typeoperation){
        try {
            TypeOperation createdDetails = typeOperationService.postTypeOperation(typeoperation);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all TypeOperation
    @GetMapping("/read")
    public ResponseEntity<List<TypeOperation>> read() {
        try{
        List<TypeOperation> lstf=typeOperationService.getTypeOperation();
        System.out.println(lstf);
        return new ResponseEntity<>(typeOperationService.getTypeOperation(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing TypeOperation
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        typeOperationService.deleteTypeOperation(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Gamme supprimé");
    return ResponseEntity.ok(response);
}


}

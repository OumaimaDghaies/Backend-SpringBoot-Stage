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

import com.r2.api.modeles.Operation;
import com.r2.api.service.OperationService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/operation")
@AllArgsConstructor
public class OperationController {
    OperationService operationService;

    //Creates a new Operation
      @PostMapping("/create")
    public ResponseEntity<Operation> create(@RequestBody Operation operation){
        try {
            Operation createdDetails = operationService.postOperation(operation);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieves all Operation
    @GetMapping("/read")
    public ResponseEntity<List<Operation>> read() {
        try{
        List<Operation> lstf=operationService.getOperation();
        System.out.println(lstf);
        return new ResponseEntity<>(operationService.getOperation(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing Operation
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        operationService.deleteOperation(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Operation supprimé");
    return ResponseEntity.ok(response);
}


}

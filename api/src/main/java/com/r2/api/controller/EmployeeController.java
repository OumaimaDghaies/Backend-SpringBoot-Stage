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

import com.r2.api.modeles.Employee;
import com.r2.api.service.EmployeeService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;


    //Creates a new employee Product
    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee familleProduitFini){
        try {
            Employee createdDetails = employeeService.postEmployee(familleProduitFini);
            return new ResponseEntity<>(createdDetails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //Retrieves all employee
    @GetMapping("/read")
    public ResponseEntity<List<Employee>> read() {
        try{
        List<Employee> lstf=employeeService.getEmployee();
        System.out.println(lstf);
        return new ResponseEntity<>(employeeService.getEmployee(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Deletes an existing employee
    @DeleteMapping("/delete/{compteur}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer compteur) {
    try {
        employeeService.deleteEmployee(compteur);
    } catch (Exception e) {
        e.printStackTrace();
    }
    Map<String, String> response = new HashMap<>();
    response.put("message", "Employee supprimé");
    return ResponseEntity.ok(response);
}
}

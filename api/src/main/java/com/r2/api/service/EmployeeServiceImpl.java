package com.r2.api.service;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Employee;
import com.r2.api.repository.EmployeeRepository;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService  {
    EmployeeRepository employeeRepository;
    
    @Override
    public Employee postEmployee(Employee employee) throws Exception {
        try{
            return employeeRepository.save(employee);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<Employee> getEmployee() throws Exception {
        return employeeRepository.findAll();
     }

    @Override
    public Employee putEmployee(Integer compteur, Employee employee) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putArticle'");
    }

    @Override
    public String deleteEmployee(Integer compteur) throws Exception {
        try{
            employeeRepository.deleteById(compteur);
            return "Employee supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}


}

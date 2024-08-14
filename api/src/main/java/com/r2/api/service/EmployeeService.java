package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Employee;

public interface EmployeeService {

    Employee postEmployee(Employee employee) throws Exception;
    List<Employee> getEmployee() throws Exception;
    Employee putEmployee (Integer compteur , Employee employee) throws Exception;
    String deleteEmployee (Integer compteur) throws Exception;
}

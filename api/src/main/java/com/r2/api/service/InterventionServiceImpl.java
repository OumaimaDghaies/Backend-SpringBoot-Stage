package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Employee;
import com.r2.api.modeles.Immobilisation;
import com.r2.api.modeles.Intervention;
import com.r2.api.modeles.Operation;
import com.r2.api.modeles.Panne;
import com.r2.api.modeles.Preparation;
import com.r2.api.repository.EmployeeRepository;
import com.r2.api.repository.ImmobilisationRepository;
import com.r2.api.repository.InterventionRepository;
import com.r2.api.repository.OperationRepository;
import com.r2.api.repository.PanneRepository;
import com.r2.api.repository.PreparationRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class InterventionServiceImpl implements InterventionService {
    InterventionRepository interventionRepository;
    ImmobilisationRepository immobilisationRepository;
    PanneRepository panneRepository;
    PreparationRepository preparationRepository;
    EmployeeRepository employeeRepository;
    OperationRepository operationRepository;

    @Override
    public Intervention postIntervention(Intervention intervention) throws Exception {
        
        try {
            // Fetch and set associated entities
           // Panne panne= panneRepository.findById(intervention.getPanne().getId())
            //        .orElseThrow(() -> new Exception("Panne not found"));
           
            //Preparation preparation= preparationRepository.findById(intervention.getPreparation().getCompteur())
            //        .orElseThrow(() -> new Exception("Preparation not found"));
            for (Panne panne : intervention.getPanne()) {
                // Ensure each Panne is managed
                Panne managedPanne = panneRepository.findById(panne.getId())
                                        .orElseThrow(() -> new RuntimeException("Panne not found"));
                panneRepository.save(managedPanne);
            }
            
            for (Preparation preparation : intervention.getPreparation()) {
                // Ensure each Panne is managed
                Preparation managedPreparation = preparationRepository.findById(preparation.getCompteur())
                                        .orElseThrow(() -> new RuntimeException("preparation not found"));
                                        preparationRepository.save(managedPreparation);
            }

           Immobilisation immobilisation= immobilisationRepository.findById(intervention.getImmobilisation().getCompteur())
                    .orElseThrow(() -> new Exception("Immobilisation not found"));
           
            Employee employee = employeeRepository.findById(intervention.getEmployee().getCompteur())
                    .orElseThrow(() -> new Exception("Employee not found"));
            Operation operation = operationRepository.findById(intervention.getOperation().getCompteur())
                    .orElseThrow(() -> new Exception("Operation not found"));

            //intervention.setPanne(panne);
            //intervention.setPreparation(preparation);
            intervention.setImmobilisation(immobilisation);
            intervention.setEmployee(employee);
            intervention.setOperation(operation);
            
            return interventionRepository.save(intervention);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }/*try{
            return interventionRepository.save(intervention);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } */}

    @Override
    public List<Intervention> getIntervention() throws Exception {
        return interventionRepository.findAll();}

    @Override
    public Intervention putIntervention(Integer id, Intervention intervention) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putInventaire'");
    }

    @Override
    public String deleteIntervention(Integer id) throws Exception {
        try{
            interventionRepository.deleteById(id);
            return "intervention supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}
/* 
    @Override
    public Intervention getInterventionById(Integer id) {
        Intervention intervention = interventionRepository.findById(id).orElse(null);
        if (intervention != null) {
            // Initialize lazy-loaded collections
            intervention.getPanne().size();
        }
        return intervention;}*/

}

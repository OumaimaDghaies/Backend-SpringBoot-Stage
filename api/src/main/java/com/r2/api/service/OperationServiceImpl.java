package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Operation;
import com.r2.api.repository.OperationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OperationServiceImpl implements OperationService {
    OperationRepository operationRepository;

    @Override
    public Operation postOperation(Operation operation) throws Exception {
        try{
            return operationRepository.save(operation);}
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }}

    @Override
    public List<Operation> getOperation() throws Exception {
        return operationRepository.findAll();}

    @Override
    public Operation putOperation(Integer compteur, Operation operation) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putOperation'");
    }

    @Override
    public String deleteOperation(Integer compteur) throws Exception {
        try{
            operationRepository.deleteById(compteur);
            return "Panne supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}

}

package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.TypeOperation;
import com.r2.api.repository.TypeOperationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeOperationServiceImpl implements TypeOperationService {
    TypeOperationRepository typeOperationRepository;
    @Override
    public TypeOperation postTypeOperation(TypeOperation typeoperation) throws Exception {
        try{
            return typeOperationRepository.save(typeoperation);}
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }}

    @Override
    public List<TypeOperation> getTypeOperation() throws Exception {
        return typeOperationRepository.findAll();}

    @Override
    public TypeOperation putTypeOperation(Integer compteur, TypeOperation typeoperation) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putTypeOperation'");
    }

    @Override
    public String deleteTypeOperation(Integer compteur) throws Exception {
        try{
            typeOperationRepository.deleteById(compteur);
            return "Panne supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}

}

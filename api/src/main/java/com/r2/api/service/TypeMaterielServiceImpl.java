package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.TypeMateriel;
import com.r2.api.repository.TypeMaterielRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeMaterielServiceImpl implements TypeMaterielService {
    TypeMaterielRepository typeMaterielRepository;
    @Override
    public TypeMateriel postTypeMateriel(TypeMateriel typemateriel) throws Exception {
        try{
            return typeMaterielRepository.save(typemateriel);}
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }}

    @Override
    public List<TypeMateriel> getTypeMateriel() throws Exception {
        return typeMaterielRepository.findAll();}

    @Override
    public TypeMateriel putTypeMateriel(Integer compteur, TypeMateriel typemateriel) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putTypeMateriel'");
    }

    @Override
    public String deleteTypeMateriel(Integer compteur) throws Exception {
        try{
            typeMaterielRepository.deleteById(compteur);
            return "Panne supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

}

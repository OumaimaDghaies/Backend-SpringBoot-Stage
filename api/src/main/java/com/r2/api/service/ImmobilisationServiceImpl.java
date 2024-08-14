package com.r2.api.service;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Immobilisation;
import com.r2.api.repository.ImmobilisationRepository;
@Service
@AllArgsConstructor
public class ImmobilisationServiceImpl implements ImmobilisationService {
    ImmobilisationRepository immobilisationRepository;
    
    @Override
    public Immobilisation postImmobilisation(Immobilisation immobilisation) throws Exception {
        try{
            return immobilisationRepository.save(immobilisation);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<Immobilisation> getImmobilisation() throws Exception {
        return immobilisationRepository.findAll();
     }

    @Override
    public Immobilisation putImmobilisation(Integer compteur, Immobilisation immobilisation) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putArticle'");
    }

    @Override
    public String deleteImmobilisation(Integer compteur) throws Exception {
        try{
            immobilisationRepository.deleteById(compteur);
            return "Immobilisation supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}


}

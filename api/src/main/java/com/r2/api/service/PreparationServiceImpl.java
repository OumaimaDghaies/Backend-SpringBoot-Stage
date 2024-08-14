package com.r2.api.service;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Preparation;
import com.r2.api.repository.PreparationRepository;
@Service
@AllArgsConstructor
public class PreparationServiceImpl implements PreparationService{
    PreparationRepository preparationRepository;
    
    @Override
    public Preparation postPreparation(Preparation preparation) throws Exception {
        try{
            return preparationRepository.save(preparation);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<Preparation> getPreparation() throws Exception {
        return preparationRepository.findAll();
     }

    @Override
    public Preparation putPreparation(Integer compteur, Preparation preparation) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putArticle'");
    }

    @Override
    public String deletePreparation(Integer compteur) throws Exception {
        try{
            preparationRepository.deleteById(compteur);
            return "preparation supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}


}

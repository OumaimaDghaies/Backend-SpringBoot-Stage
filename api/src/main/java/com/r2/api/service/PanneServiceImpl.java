package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Panne;
import com.r2.api.repository.PanneRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PanneServiceImpl  implements PanneService{

    PanneRepository panneRepository;
    
    @Override
    public Panne postPanne(Panne panne) throws Exception {
        try{
            return panneRepository.save(panne);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } }

    @Override
    public List<Panne> getPanne() throws Exception {
        return panneRepository.findAll();}

    @Override
    public Panne putPanne(Integer id, Panne panne) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putPanne'");
    }

    @Override
    public String deletePanne(Integer id) throws Exception {
        try{
            panneRepository.deleteById(id);
            return "Panne supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }}

}

package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Gamme;
import com.r2.api.modeles.ProduitFini;
import com.r2.api.repository.GammeRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GammeServiceImpl  implements GammeService{

    GammeRepository gammeRepository;

    @Override
    public Gamme postRange(Gamme gamme) throws Exception {
      try{

        List<ProduitFini> l = gamme.getListproduitsFinis();
        gamme.setListproduitsFinis(l);
        l.forEach(el-> {
            el.setGamme(gamme);
        });
            return gammeRepository.save(gamme);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    
    }

    @Override
    public List<Gamme> getRange() throws Exception {
        return gammeRepository.findAll();
      }

    @Override
    public Gamme putRange(Integer compteur, Gamme gamme) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putRange'");
    }

    @Override
    public String deleteRange(Integer compteur) throws Exception {
        try{
            
            gammeRepository.deleteById(compteur);
            return "Gamme supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } 
       
    
    }

    @Override
    public Optional<Gamme> getGammeById(Integer id) {
        return gammeRepository.findById(id); }

}

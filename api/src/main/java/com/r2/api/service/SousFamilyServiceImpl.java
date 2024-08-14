package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.SousFamille;
import com.r2.api.repository.SousFamilyRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class SousFamilyServiceImpl implements SousFamilyService {

    SousFamilyRepository sousfamilyRepository ;

    //Creates a new sub-family
    @Override
    public SousFamille postSubFamily(SousFamille sousfamille) {
        try{
        return sousfamilyRepository.save(sousfamille);}
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //Retrieves all sub-families
    @Override
    public List<SousFamille> getSubFamily() {

        return sousfamilyRepository.findAll();
    }

    //Updates an existing sub-family
    @Override
    public SousFamille putSubFamily(Integer idsousfamille, SousFamille sousfamille) {
        return sousfamilyRepository.findById(idsousfamille).map(f-> {

            f.setLibellesousfamille(sousfamille.getLibellesousfamille());
            return sousfamilyRepository.save(f);

        }).orElseThrow(()-> new RuntimeException("Sous famille non trouvé"));
    }

    //Deletes an existing sub-family
    
    @Override
    public String deleteSubFamily(Integer idsousfamille) {
        try{
            sousfamilyRepository.deleteById(idsousfamille);
            return "Sous Famille supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}

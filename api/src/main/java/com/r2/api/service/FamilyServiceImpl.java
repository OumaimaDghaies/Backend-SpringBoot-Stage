package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.Famille;
import com.r2.api.modeles.SousFamille;
import com.r2.api.repository.FamilyRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class FamilyServiceImpl implements FamilyService{

     FamilyRepository familyRepository ;

     //Creates a new family
    @Override
    public Famille postFamily(Famille famille) throws Exception{
        try{
            
            List<SousFamille> l= famille.getListeSousFamilles();
            famille.setListeSousFamilles(l);
            l.forEach(el->{
                el.setFamille(famille);
            });
            return familyRepository.save(famille);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //Retrieves all families
    @Override
    public List<Famille> getFamily() throws Exception{
        return familyRepository.findAll();
    }
     //Updates an existing family
    @Override
    public Famille putFamily(Integer id, Famille famille) throws Exception {
        return familyRepository.findById(id).map(f-> {

            f.setLibelle(famille.getLibelle());
            return familyRepository.save(f);

        }).orElseThrow(()-> new RuntimeException("famille non trouvé"));
    }

    //Deletes an existing family
    @Override
    public String deleteFamily(Integer id)throws Exception {
        try{
            familyRepository.deleteById(id);
            return "Famille supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    

}

    @Override
    public Optional<Famille> getFamilyById(Integer id) {
        return familyRepository.findById(id); }}

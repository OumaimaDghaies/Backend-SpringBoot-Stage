package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.FamilleProduitFini;
import com.r2.api.modeles.ProduitFini;
import com.r2.api.repository.FamilleProduitFiniRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FamilleProduitFiniServiceImpl implements FamilleProduitFiniService {

    FamilleProduitFiniRepository familleProduitFiniRepository;

    @Override
    public FamilleProduitFini postFamilyProduct(FamilleProduitFini famillePFini) throws Exception {
        try{
            List<ProduitFini> l = famillePFini.getListproduitsFinis();
            famillePFini.setListproduitsFinis(l);
        l.forEach(el-> {
            el.setFamilleproduitfini(famillePFini);
        });
            
            return familleProduitFiniRepository.save(famillePFini);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FamilleProduitFini> getFamilyProduct() throws Exception {
            return familleProduitFiniRepository.findAll();    
    }

    @Override
    public FamilleProduitFini putFamilyProduct(Integer id, FamilleProduitFini famillePFini) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putFamilyProduct'");
    }

    @Override
    public String deleteFamilyProduct(Integer id) throws Exception {
        try{
            familleProduitFiniRepository.deleteById(id);
            return "Famille Produit Fini supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Optional<FamilleProduitFini> getFamilleProduitFiniById(Integer id) {
        return familleProduitFiniRepository.findById(id);}

}

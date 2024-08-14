package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.ProduitFini;
import com.r2.api.repository.ProduitFiniRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProduitFiniServiceImpl  implements ProduitFiniService{
    
    ProduitFiniRepository produitFiniRepository;
    
    @Override
    public String deleteProductF(Integer id) throws Exception {
        try{
            produitFiniRepository.deleteById(id);
            return "Produit Fini supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        } 
    }

    @Override
    public List<ProduitFini> getProductF() throws Exception {
        // TODO Auto-generated method stub
        return produitFiniRepository.findAll();
    }

    @Override
    public ProduitFini postProductF(ProduitFini produitFini) throws Exception {
        try{
            return produitFiniRepository.save(produitFini);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ProduitFini putProductF(Integer id, ProduitFini produitFini) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}

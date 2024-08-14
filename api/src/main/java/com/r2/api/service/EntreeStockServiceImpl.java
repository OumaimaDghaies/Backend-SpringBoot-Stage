package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.EntreeStock;
import com.r2.api.modeles.DetailsEntreeStock;
import com.r2.api.repository.EntreeStockRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntreeStockServiceImpl implements EntreeStockService {

    EntreeStockRepository entreeStockRepository;

    //Creates a new stock-entry
    @Override
    public EntreeStock postStockEntry(EntreeStock entreestock) {
        try{
            List<DetailsEntreeStock> l= entreestock.getListeDetailsEntreeStock();
            entreestock.setListeDetailsEntreeStock(l);
            l.forEach(el->{
                el.setEntreestock(entreestock);
            });
        return entreeStockRepository.save(entreestock);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //Retrieves all stock-entry
    @Override
    public List<EntreeStock> getStockEntry() {
        return entreeStockRepository.findAll();
    }

    @Override
    public EntreeStock putStockEntry(Integer compteur, EntreeStock entreestock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifier'");
    }

    @Override
    public String deleteStockEntry(Integer compteur) {
        try{
            entreeStockRepository.deleteById(compteur);
            return "Entrée Stock supprimé";
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }   
    }

}

package com.r2.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.r2.api.modeles.DetailsEntreeStock;
import com.r2.api.repository.DetailsEntreeStockRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DetailsEntreeStockServiceImpl implements DetailsEntreeStockService {
    DetailsEntreeStockRepository detailsEntreeStockRepository;

    //Creates a new stock entry details
    @Override
    public DetailsEntreeStock postStockEntryDetails(DetailsEntreeStock detailsEntreeStock) {
        try{
        return detailsEntreeStockRepository.save(detailsEntreeStock);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    //Retrieves all stock entry details
    @Override
    public List<DetailsEntreeStock> getStockEntryDetails() {
        return detailsEntreeStockRepository.findAll();
    }

    @Override
    public DetailsEntreeStock putStockEntryDetails(Integer compteur, DetailsEntreeStock detailsEntreeStock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifier'");
    }

    @Override
    public String deleteStockEntryDetails(Integer compteur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supprimer'");
    }

}

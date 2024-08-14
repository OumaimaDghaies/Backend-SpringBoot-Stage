package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.DetailsEntreeStock;

public interface DetailsEntreeStockService {
    DetailsEntreeStock postStockEntryDetails(DetailsEntreeStock detailsEntreeStock) throws Exception;
    List<DetailsEntreeStock> getStockEntryDetails() throws Exception;
    DetailsEntreeStock putStockEntryDetails (Integer compteur , DetailsEntreeStock detailsEntreeStock) throws Exception;
    String deleteStockEntryDetails (Integer compteur) throws Exception;

}

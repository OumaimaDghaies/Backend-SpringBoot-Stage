package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.EntreeStock;

public interface EntreeStockService {
    EntreeStock postStockEntry(EntreeStock entreestock) throws Exception;
    List<EntreeStock> getStockEntry() throws Exception;
    EntreeStock putStockEntry (Integer compteur , EntreeStock entreestock) throws Exception;
    String deleteStockEntry (Integer compteur) throws Exception;

}

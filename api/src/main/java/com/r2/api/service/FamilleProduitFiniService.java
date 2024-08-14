package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import com.r2.api.modeles.FamilleProduitFini;

public interface FamilleProduitFiniService {
    FamilleProduitFini postFamilyProduct(FamilleProduitFini famillePFini) throws Exception;
    List<FamilleProduitFini> getFamilyProduct() throws Exception;
    FamilleProduitFini putFamilyProduct (Integer id , FamilleProduitFini famillePFini) throws Exception;
    String deleteFamilyProduct (Integer id) throws Exception;
    Optional<FamilleProduitFini> getFamilleProduitFiniById(Integer id);

}

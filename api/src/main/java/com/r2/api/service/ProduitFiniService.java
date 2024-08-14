package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.ProduitFini;

public interface ProduitFiniService {
    ProduitFini postProductF(ProduitFini produitFini) throws Exception;
    List<ProduitFini> getProductF() throws Exception;
    ProduitFini putProductF (Integer id , ProduitFini produitFini) throws Exception;
    String deleteProductF (Integer id) throws Exception;


}

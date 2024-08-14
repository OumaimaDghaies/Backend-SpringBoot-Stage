package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Panne;

public interface PanneService {
    Panne postPanne(Panne panne) throws Exception;
    List<Panne> getPanne() throws Exception;
    Panne putPanne (Integer id , Panne panne) throws Exception;
    String deletePanne (Integer id) throws Exception;
}

package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Intervention;

public interface InterventionService {
    Intervention postIntervention(Intervention intervention) throws Exception;
    List<Intervention> getIntervention() throws Exception;
    Intervention putIntervention (Integer id , Intervention intervention) throws Exception;
    String deleteIntervention (Integer id) throws Exception;
    //Intervention getInterventionById(Integer id);

}

package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Immobilisation;

public interface ImmobilisationService {
    Immobilisation postImmobilisation(Immobilisation immobilisation) throws Exception;
    List<Immobilisation> getImmobilisation() throws Exception;
    Immobilisation putImmobilisation (Integer compteur , Immobilisation immobilisation) throws Exception;
    String deleteImmobilisation (Integer compteur) throws Exception;

}

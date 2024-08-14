package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Preparation;

public interface PreparationService {
    Preparation postPreparation(Preparation preparation) throws Exception;
    List<Preparation> getPreparation() throws Exception;
    Preparation putPreparation (Integer compteur , Preparation preparation) throws Exception;
    String deletePreparation (Integer compteur) throws Exception;
}

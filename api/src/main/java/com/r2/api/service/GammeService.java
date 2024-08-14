package com.r2.api.service;

import java.util.List;
import java.util.Optional;

import com.r2.api.modeles.Gamme;

public interface GammeService {

    Gamme postRange(Gamme gamme) throws Exception;
    List<Gamme> getRange() throws Exception;
    Gamme putRange (Integer compteur , Gamme gamme) throws Exception;
    String deleteRange (Integer compteur) throws Exception;
    Optional<Gamme> getGammeById(Integer id);

}

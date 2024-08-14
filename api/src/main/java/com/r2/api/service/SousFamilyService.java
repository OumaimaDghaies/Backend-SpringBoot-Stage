package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.SousFamille;

public interface SousFamilyService {
    SousFamille postSubFamily(SousFamille sousfamille) throws Exception;
    List<SousFamille> getSubFamily() throws Exception;
    SousFamille putSubFamily (Integer idsousfamille , SousFamille sousfamille) throws Exception;
    String deleteSubFamily (Integer idsousfamille) throws Exception;

}

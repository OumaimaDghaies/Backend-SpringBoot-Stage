package com.r2.api.service;


import java.util.List;
import java.util.Optional;

import com.r2.api.modeles.Famille;

public interface FamilyService {
    Famille postFamily(Famille famille) throws Exception;
    List<Famille> getFamily() throws Exception;
    Famille putFamily (Integer id , Famille famille) throws Exception;
    String deleteFamily (Integer id) throws Exception;
    Optional<Famille> getFamilyById(Integer id);


}

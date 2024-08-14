package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.TypeMateriel;

public interface TypeMaterielService {
    TypeMateriel postTypeMateriel(TypeMateriel typemateriel) throws Exception;
    List<TypeMateriel> getTypeMateriel() throws Exception;
    TypeMateriel putTypeMateriel (Integer compteur , TypeMateriel typemateriel) throws Exception;
    String deleteTypeMateriel (Integer compteur) throws Exception;

}

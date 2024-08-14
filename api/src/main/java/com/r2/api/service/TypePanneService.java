package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.TypePanne;

public interface TypePanneService {
    TypePanne postTypePanne(TypePanne typepanne) throws Exception;
    List<TypePanne> getTypePanne() throws Exception;
    TypePanne putTypePanne (Integer id , TypePanne typepanne) throws Exception;
    String deleteTypePanne (Integer id) throws Exception;

}

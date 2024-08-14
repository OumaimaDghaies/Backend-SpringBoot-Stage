package com.r2.api.service;

import java.util.List;
import com.r2.api.modeles.TypeOperation;

public interface TypeOperationService {
    TypeOperation postTypeOperation(TypeOperation typeoperation) throws Exception;
    List<TypeOperation> getTypeOperation() throws Exception;
    TypeOperation putTypeOperation (Integer compteur , TypeOperation typeoperation) throws Exception;
    String deleteTypeOperation (Integer compteur) throws Exception;

}

package com.r2.api.service;

import java.util.List;

import com.r2.api.modeles.Operation;

public interface OperationService {
     Operation postOperation(Operation operation) throws Exception;
    List<Operation> getOperation() throws Exception;
    Operation putOperation (Integer compteur , Operation operation) throws Exception;
    String deleteOperation (Integer compteur) throws Exception;


}

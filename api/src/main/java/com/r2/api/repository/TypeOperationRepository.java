package com.r2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.r2.api.modeles.TypeOperation;

@Repository
public interface TypeOperationRepository extends JpaRepository<TypeOperation, Integer>{

}

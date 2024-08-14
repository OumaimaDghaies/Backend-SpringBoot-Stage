package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "typeOperation")
@Getter
@Setter
@NoArgsConstructor
public class TypeOperation {
     @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="codeTypeOperation")
    private String codeTypeOperation;
    @Column(name="libelleTypeOperation")
    private String libelleTypeOperation;
    @Column(name="OrdreImpression")
    private String OrdreImpression;

    @OneToMany(mappedBy = "typeoperation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "typeoperation-operation")
    private List<Operation> listoperations= new ArrayList<Operation>();

}

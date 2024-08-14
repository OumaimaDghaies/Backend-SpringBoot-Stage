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
@Table(name = "typeMateriel")
@Getter
@Setter
@NoArgsConstructor
public class TypeMateriel {
    @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="codeTypeMateriel")
    private String codeTypeMateriel;
    @Column(name="libelleTypeMateriel")
    private String libelleTypeMateriel;

    @OneToMany(mappedBy = "typemateriel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "typemateriel-operation")
    private List<Operation> listoperations= new ArrayList<Operation>();


}

package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operation")
@Getter
@Setter
@NoArgsConstructor
public class Operation {
    @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="codeOperation")
    private String codeOperation;
    @Column(name="libelleOperation")
    private String libelleOperation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("typemateriel")
    @JsonBackReference(value = "typemateriel-operation")
    @JoinColumn(name="typemateriel", nullable=false, referencedColumnName ="compteur")
    private TypeMateriel typemateriel;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("typeoperation")
    @JsonBackReference(value = "typeoperation-operation")
    @JoinColumn(name="typeoperation", nullable=false, referencedColumnName ="compteur")
    private TypeOperation typeoperation;


    @JsonInclude
    @JsonProperty("Libelletypeoperation")
    public String gettypeoperationLibelle() {
        return typeoperation != null ? typeoperation.getLibelleTypeOperation() : null;
    }

    @JsonInclude
    @JsonProperty("Libelletypemateriel")
    public String gettypematerielLibelle() {
        return typemateriel != null ? typemateriel.getLibelleTypeMateriel() : null;
    }
    

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "operation-intervention")
    private List<Intervention> listInterventions= new ArrayList<Intervention>();
}

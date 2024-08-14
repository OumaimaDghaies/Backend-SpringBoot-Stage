package com.r2.api.modeles;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "intervention")
@Getter
@Setter
@NoArgsConstructor
public class Intervention {
     @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="code")
    private String code;
    @Column(name="description")
    private String description;
    @Column(name="dateDemande")
    private Date dateDemande;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "intervention_panne",
        joinColumns = @JoinColumn(name = "intervention_id"),
        inverseJoinColumns = @JoinColumn(name = "panne_id")
    )
    @JsonBackReference(value = "panne-intervention")
    //@JsonIgnoreProperties("interventions")
    private Set<Panne> panne;

    // Add other ManyToOne relationships as needed

    @JsonInclude
    @JsonProperty("panneLibelle")
    public List<String> getLibellePanne() {
        
            return panne.stream().map(Panne::getLibellePanne).toList();
        
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "intervention_preparation",
        joinColumns = @JoinColumn(name = "intervention_id"),
        inverseJoinColumns = @JoinColumn(name = "preparation_id")
    )
    @JsonBackReference(value = "preparation-intervention")
    //@JsonIgnoreProperties("interventions")
    private Set<Preparation> preparation;

    // Add other ManyToOne relationships as needed

    @JsonInclude
    @JsonProperty("preparationLibelle")
    public List<String> getLibellePreparation() {
        
            return preparation.stream().map(Preparation::getLibellePreparation).toList();
        
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("immobilisation")
    @JsonBackReference(value = "immobilisation-intervention")
    @JoinColumn(name="immobilisation", nullable = false, referencedColumnName ="compteur")
    private Immobilisation immobilisation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("employee")
    @JsonBackReference(value = "employee-intervention")
    @JoinColumn(name="employee", nullable = false, referencedColumnName ="compteur")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("operation")
    @JsonBackReference(value = "operation-intervention")
    @JoinColumn(name="operation", nullable = false, referencedColumnName ="compteur")
    private Operation operation;


    
    @JsonInclude
    @JsonProperty("employeeLibelle")
    public String getemployeeLibelle() {
        return employee != null ? employee.getLibelleEmployee() : null;
    }
    @JsonInclude
    @JsonProperty("operationLibelle")
    public String getLibelleOperation() {
        return operation != null ? operation.getLibelleOperation() : null;
    }

    @JsonInclude
    @JsonProperty("immobilisationDesignation")
    public String getDesignationImmobilisation() {
        return immobilisation != null ? immobilisation.getDesignation() : null;
    }
    
   
   
    
}

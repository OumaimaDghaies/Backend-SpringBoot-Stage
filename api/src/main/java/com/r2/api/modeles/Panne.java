package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panne")
@Getter
@Setter
@NoArgsConstructor
public class Panne {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="libellePanne")
    private String libellePanne;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("typepanne")
    @JsonBackReference(value = "typepanne-panne")
    @JoinColumn(name="typePanne", referencedColumnName ="id", nullable = false)
    private TypePanne typepanne;

    @JsonInclude
    @JsonProperty("typepanneLibelle")
    public String getLibelleTypePanne() {
        return typepanne != null ? typepanne.getLibelleTypePanne() : null;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "intervention_panne",
        joinColumns = @JoinColumn(name = "panne_id "),
        inverseJoinColumns = @JoinColumn(name = "intervention_id")
    )
    @JsonBackReference(value = "panne-intervention")
    //@JsonIgnoreProperties("interventions")
    private Set<Intervention> intervention;
 
 
    
}

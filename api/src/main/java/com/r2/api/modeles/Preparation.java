package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "preparation")
@Getter
@Setter
@NoArgsConstructor
public class Preparation {
    @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="codePreparation")
    private String codePreparation;
    @Column(name="libellePreparation")
    private String libellePreparation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "intervention_preparation",
        joinColumns = @JoinColumn(name = "preparation_id "),
        inverseJoinColumns = @JoinColumn(name = "intervention_id")
    )
    @JsonBackReference(value = "preparation-intervention")
    //@JsonIgnoreProperties("interventions")
    private Set<Preparation> preparation;
}

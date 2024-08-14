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
@Table(name = "immobilisation")
@Getter
@Setter
@NoArgsConstructor
public class Immobilisation {
    @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="designation")
    private String designation;
    @Column(name="emplacement")
    private String emplacement;
    @Column(name="numSerie")
    private String numSerie;
    @Column(name="groupe")
    private String groupe;
    @OneToMany(mappedBy = "immobilisation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "immobilisation-intervention")
    private List<Intervention> listInterventions= new ArrayList<Intervention>();

}

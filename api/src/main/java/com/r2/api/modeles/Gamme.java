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
@Table(name = "gamme")
@Getter
@Setter
@NoArgsConstructor

public class Gamme {
    @Id
    @Column(name="compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="codeGamme")
    private String codeGamme;
    @Column(name="libelleGamme")
    private String libelleGamme;
    @Column(name="gammeReferences")
    private Boolean gammeReferences;
    @Column(name="codeGammeReference")
    private String codeGammeReference;
    @Column(name="qtePiquage")
    private Double qtePiquage;
    @Column(name="qteControle")
    private Double qteControle;
    @Column(name="qteExpedition")
    private Double qteExpedition;
    @Column(name="codeGammeMillet")
    private String codeGammeMillet;

    @OneToMany(mappedBy = "gamme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "gamme-produitFini")
    private List<ProduitFini> listproduitsFinis= new ArrayList<ProduitFini>();


    
}

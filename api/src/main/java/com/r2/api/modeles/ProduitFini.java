package com.r2.api.modeles;


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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produitFini")
@Getter
@Setter
@NoArgsConstructor

public class ProduitFini {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="codeP")
    private String codeP;
    @Column(name="libelle")
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("gamme")
    @JsonBackReference(value = "gamme-produitFini")
    @JoinColumn(name="gammeid", referencedColumnName ="compteur", nullable = false)
    private Gamme gamme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("familleProduitFini")
    @JsonBackReference(value = "familleProduitFini-produitFini")
    @JoinColumn(name="famillePF", referencedColumnName ="id",  nullable = false)
    private FamilleProduitFini familleproduitfini;


    @JsonInclude
    @JsonProperty("gammeLibelle")
    public String getLibelleGamme() {
        return gamme != null ? gamme.getLibelleGamme() : null;
    }

    @JsonInclude
    @JsonProperty("FamillePFLibelle")
    public String getFamillePFLibelle() {
        return familleproduitfini != null ? familleproduitfini.getLibelle() : null;
    }
  

   
    

}

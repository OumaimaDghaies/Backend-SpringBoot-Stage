package com.r2.api.modeles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "DetailsEntreeStock")
@Getter
@Setter
@NoArgsConstructor

public class DetailsEntreeStock {
    @Id
    @Column(name="Compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    
    @Column(name="CodeArticle")
    private String codeArticle;
    @Column(name="CodeProduitFini")
    private String codeProduitFini;
    @Column(name="NumLot")
    private String numLot;
    @Column(name="QteListeColisage")
    private Double qteListeColisage;
    @Column(name="QteEntree")
    private Double qteEntree;
    @Column(name="QteRetour")
    private Double qteRetour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("listeDetailsEntreeStock")
    @JsonBackReference
	@JoinColumn(name = "codeEntree",referencedColumnName = "codeEntree")
	private EntreeStock entreestock;


}

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
@Table(name = "Article")
@Getter
@Setter
@NoArgsConstructor

public class Article {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="codeArticle")
    private String codeArticle;
    @Column(name="libelle")
    private String libelle;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("famille")
    @JsonBackReference(value = "famille-article")
    @JoinColumn(name="famille", nullable=false, referencedColumnName ="id")
    private Famille famille;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("sousfamille")
    @JsonBackReference(value = "sousfamille-article")
    @JoinColumn(name="sousfamille", nullable=false, referencedColumnName ="idsousfamille")
    private SousFamille sousfamille;


    @JsonInclude
    @JsonProperty("familleLibelle")
    public String getFamilleLibelle() {
        return famille != null ? famille.getLibelle() : null;
    }

    @JsonInclude
    @JsonProperty("sousFamilleLibelle")
    public String getSousFamilleLibelle() {
        return sousfamille != null ? sousfamille.getLibellesousfamille() : null;
    }
}

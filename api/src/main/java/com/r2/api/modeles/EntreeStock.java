package com.r2.api.modeles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "EntreeStock")
@Getter
@Setter
@NoArgsConstructor

public class EntreeStock {
    @Id
    @Column(name="Compteur")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer compteur;
    @Column(name="CodeEntree" , unique = true)
    private String codeEntree;
    @Column(name="ReferenceCommandeClient")
    private String referenceCommandeClient;
    @Column(name="CodeFournisseur")
    private String codeFournisseur;
    @Column(name="CodeSourceEntree")
    private String codeSourceEntree;
    @Column(name="CodeStatusEntree")
    private String codeStatusEntree;
    @Column(name="DateColisage")
    private Date dateColisage;
    @Column(name="DateEntree")
    private Date dateEntree;

    @OneToMany(mappedBy="entreestock" ,  cascade = CascadeType.ALL , fetch = FetchType.LAZY, orphanRemoval = true)
	private List<DetailsEntreeStock> listeDetailsEntreeStock = new ArrayList<DetailsEntreeStock>();

}

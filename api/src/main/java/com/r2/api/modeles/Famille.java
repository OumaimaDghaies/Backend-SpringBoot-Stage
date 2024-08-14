package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "famille")
@Getter
@Setter
@NoArgsConstructor

public class Famille {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="libelle")
    private String libelle;

    @OneToMany(mappedBy="famille", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonManagedReference(value = "famille-sousfamille")
	private List<SousFamille> listeSousFamilles = new ArrayList<SousFamille>();

    
    @OneToMany(mappedBy = "famille", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    
    @JsonManagedReference(value = "famille-article")
    private List<Article> listArticles= new ArrayList<Article>();

}

package com.r2.api.modeles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "sousfamille")
@Getter
@Setter
@NoArgsConstructor

public class SousFamille {
    @Id
    @Column(name="idsousfamille")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idsousfamille;
    @Column(name="libellesousfamille")
    private String libellesousfamille;

    @ManyToOne
    @JsonIgnoreProperties("famille")
    @JsonBackReference(value = "famille-sousfamille")
	@JoinColumn(name = "idf",referencedColumnName = "id")
	private Famille famille;
 

    
    @OneToMany(mappedBy = "sousfamille", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "sousfamille-article")
    private List<Article> listArticles= new ArrayList<Article>();

}

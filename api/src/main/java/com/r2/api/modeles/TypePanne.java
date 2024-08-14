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
@Table(name = "typepanne")
@Getter
@Setter
@NoArgsConstructor
public class TypePanne {
    @Id
    @Column(name="id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="codeTypePanne")
    private String codeTypePanne;
    @Column(name="libelleTypePanne")
    private String libelleTypePanne;

@OneToMany(mappedBy = "typepanne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference(value = "typepanne-panne")
    private List<Panne> listpannes= new ArrayList<Panne>();
}

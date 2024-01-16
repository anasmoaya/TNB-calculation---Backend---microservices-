package com.tnb.terrainservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categorie;
    private double surface;

    @ManyToOne
    @JoinColumn(name = "cin_proprietaire")
    private Proprietaire proprietaire;
}
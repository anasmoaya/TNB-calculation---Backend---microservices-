package com.tnb.terrainservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proprietaire {
    @Id
    private String cin;

    private String nom;
    private String prenom;

}
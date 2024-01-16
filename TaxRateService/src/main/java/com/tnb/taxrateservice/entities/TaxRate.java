package com.tnb.taxrateservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tax_rate")
public class TaxRate {
    @Id
    @Column(name = "categorie", nullable = false)
    private String categorie;
    private Double taux;

}
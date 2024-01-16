package com.tnb.taxcalculationservice.services;

import com.tnb.taxcalculationservice.clients.TaxRateClient;
import com.tnb.taxcalculationservice.clients.TerrainClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxCalculationService {

    private final TaxRateClient taxRateClient;
    private  final TerrainClient terrainClient;

    @Autowired
    public TaxCalculationService(TaxRateClient taxRateClient , TerrainClient terrainClient) {
        this.taxRateClient = taxRateClient;
        this.terrainClient = terrainClient;
    }

    public Double calculateTax(Long idTerrain) {
        String categorie = terrainClient.getCategorieById(idTerrain);
        Double taux = taxRateClient.getTaxRateByCategorie(categorie);
        Double surface = terrainClient.getSurfaceById(idTerrain);
        return taux * surface;
    }
}
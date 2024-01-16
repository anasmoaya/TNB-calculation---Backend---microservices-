package com.tnb.terrainservice.services;

import com.tnb.terrainservice.clients.TaxRateClient;
import com.tnb.terrainservice.entities.Proprietaire;
import com.tnb.terrainservice.entities.Terrain;
import com.tnb.terrainservice.repositories.ProprietaireRepository;
import com.tnb.terrainservice.repositories.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TerrainService {



    private final TaxRateClient taxRateClient;

    private final TerrainRepository terrainRepository;
    private final ProprietaireRepository proprietaireRepository;


    @Autowired
    public TerrainService(TerrainRepository terrainRepository,
                          ProprietaireRepository proprietaireRepository , TaxRateClient taxRateClient) {
        this.terrainRepository = terrainRepository;
        this.proprietaireRepository = proprietaireRepository;
        this.taxRateClient = taxRateClient;
    }

    public Terrain saveTerrain(Terrain terrain) {
        Proprietaire proprietaire = terrain.getProprietaire();
        if(proprietaire != null){
            proprietaireRepository.save(proprietaire);
        }
        return terrainRepository.saveAndFlush(terrain);
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Terrain getTerrainById(Long id) {
        return terrainRepository.findById(id).orElse(null);
    }

    public List<Terrain> getTerrainsByProprietaire(String cin) {
        return terrainRepository.findByCinProprietaire(cin);
    }

    public Terrain updateTerrain(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteTerrain(Long id) {
        terrainRepository.deleteById(id);
    }

    public Double fetchTaxRateForCategorie(String categorie) {
        return taxRateClient.getTaxRateByCategorie(categorie);
    }



    // Vous pouvez ajouter d'autres méthodes selon les besoins de votre application
}

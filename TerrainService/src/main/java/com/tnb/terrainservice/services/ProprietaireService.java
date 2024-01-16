package com.tnb.terrainservice.services;

import com.tnb.terrainservice.entities.Proprietaire;
import com.tnb.terrainservice.entities.Terrain;
import com.tnb.terrainservice.repositories.ProprietaireRepository;
import com.tnb.terrainservice.repositories.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireService {

    private final ProprietaireRepository proprietaireRepository;
    private final TerrainRepository terrainRepository;

    @Autowired
    public ProprietaireService(ProprietaireRepository proprietaireRepository,
                               TerrainRepository terrainRepository) {
        this.proprietaireRepository = proprietaireRepository;
        this.terrainRepository = terrainRepository;
    }

    public Proprietaire saveProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepository.findAll();
    }

    public Optional<Proprietaire> getProprietaireByCin(String cin) {
        return proprietaireRepository.findById(cin);
    }

    public Proprietaire updateProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    public void deleteProprietaire(String cin) {
        proprietaireRepository.deleteById(cin);
    }

}

package com.tnb.terrainservice.controllers;

import com.tnb.terrainservice.entities.Terrain;
import com.tnb.terrainservice.services.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrains")
public class TerrainController {

    private final TerrainService terrainService;
    @Autowired
    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @PostMapping
    public ResponseEntity<Terrain> createTerrain(@RequestBody Terrain terrain) {
        Terrain savedTerrain = terrainService.saveTerrain(terrain);
        return ResponseEntity.ok(savedTerrain);
    }

    @GetMapping
    public ResponseEntity<List<Terrain>> getAllTerrains() {
        return ResponseEntity.ok(terrainService.getAllTerrains());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Long id) {
        Terrain terrain = terrainService.getTerrainById(id);
        return terrain != null ? ResponseEntity.ok(terrain) : ResponseEntity.notFound().build();
    }
    @GetMapping("/surface/{id}")
    public Double getSurfaceById(@PathVariable Long id) {
        Terrain terrain = terrainService.getTerrainById(id);
        return terrain != null ? terrain.getSurface() : -1;
    }

    @GetMapping("/categorie/{id}")
    public String getCategorieById(@PathVariable Long id) {
        Terrain terrain = terrainService.getTerrainById(id);
        return terrain != null ? terrain.getCategorie() : "";
    }
    @GetMapping("/taxRate/{id}")
    public ResponseEntity<Double> getRateTax(@PathVariable Long id){
        Terrain terrain = terrainService.getTerrainById(id);
        return   terrain != null ? ResponseEntity.ok( terrainService.fetchTaxRateForCategorie(terrain.getCategorie())) :ResponseEntity.notFound().build();
    }

    @GetMapping("/proprietaire/{cin}")
    public ResponseEntity<List<Terrain>> getTerrainsByProprietaire(@PathVariable String cin) {
        return ResponseEntity.ok(terrainService.getTerrainsByProprietaire(cin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Long id, @RequestBody Terrain terrain) {
        Terrain updatedTerrain = terrainService.updateTerrain(terrain);
        return ResponseEntity.ok(updatedTerrain);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Long id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.ok().build();
    }

}
package com.tnb.terrainservice.controllers;

import com.tnb.terrainservice.entities.Proprietaire;
import com.tnb.terrainservice.services.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proprietaires")
public class ProprietaireController {

    private final ProprietaireService proprietaireService;

    @Autowired
    public ProprietaireController(ProprietaireService proprietaireService) {
        this.proprietaireService = proprietaireService;
    }

    @PostMapping
    public ResponseEntity<Proprietaire> createProprietaire(@RequestBody Proprietaire proprietaire) {
        Proprietaire savedProprietaire = proprietaireService.saveProprietaire(proprietaire);
        return ResponseEntity.ok(savedProprietaire);
    }

    @GetMapping
    public ResponseEntity<List<Proprietaire>> getAllProprietaires() {
        return ResponseEntity.ok(proprietaireService.getAllProprietaires());
    }

    @GetMapping("/{cin}")
    public ResponseEntity<Proprietaire> getProprietaireByCin(@PathVariable String cin) {
        Optional<Proprietaire> proprietaire = proprietaireService.getProprietaireByCin(cin);
        return proprietaire.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Proprietaire> updateProprietaire(@PathVariable String cin, @RequestBody Proprietaire proprietaire) {
        Proprietaire updatedProprietaire = proprietaireService.updateProprietaire(proprietaire);
        return ResponseEntity.ok(updatedProprietaire);
    }

    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> deleteProprietaire(@PathVariable String cin) {
        proprietaireService.deleteProprietaire(cin);
        return ResponseEntity.ok().build();
    }

}

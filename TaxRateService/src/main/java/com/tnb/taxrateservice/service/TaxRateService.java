package com.tnb.taxrateservice.service;

import com.tnb.taxrateservice.entities.TaxRate;
import com.tnb.taxrateservice.repositories.TaxRateRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class TaxRateService {
    private final TaxRateRepository taxRateRepository;

    @Autowired
    public TaxRateService(TaxRateRepository taxRateRepository) {
        this.taxRateRepository = taxRateRepository;
    }




    // Create - Ajouter un nouveau taux de taxe
    public TaxRate createTaxRate(TaxRate taxRate) {
        return taxRateRepository.save(taxRate);
    }

    // Read - Obtenir tous les taux de taxe
    public List<TaxRate> getAllTaxRates() {
        return taxRateRepository.findAll();
    }

    // Read - Obtenir un taux de taxe par ID
    public Optional<TaxRate> getTaxRateByCategorie(String categorie) {
        return taxRateRepository.findById(categorie);
    }

    // Update - Mettre à jour un taux de taxe
    public TaxRate updateTaxRate(TaxRate taxRate) {
        return taxRateRepository.save(taxRate);
    }

    // Delete - Supprimer un taux de taxe
    public void deleteTaxRate(String categorie) {
        TaxRate taxRate = taxRateRepository.findById(categorie).orElseThrow(()->new NotFoundException("not found"));
        taxRateRepository.delete(taxRate);
    }



}


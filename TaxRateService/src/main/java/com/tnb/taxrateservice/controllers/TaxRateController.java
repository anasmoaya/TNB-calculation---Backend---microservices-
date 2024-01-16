package com.tnb.taxrateservice.controllers;

import com.tnb.taxrateservice.entities.TaxRate;
import com.tnb.taxrateservice.repositories.TaxRateRepository;
import com.tnb.taxrateservice.service.TaxRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxrates")
public class TaxRateController {

    private final TaxRateService taxRateService;
    private final TaxRateRepository taxRateRepository;

    @Autowired
    public TaxRateController(TaxRateService taxRateService,
                             TaxRateRepository taxRateRepository) {
        this.taxRateService = taxRateService;
        this.taxRateRepository = taxRateRepository;
    }

    @PostMapping
    public ResponseEntity<TaxRate> createTaxRate(@RequestBody TaxRate taxRate) {
        TaxRate savedTaxRate = taxRateService.createTaxRate(taxRate);
        return ResponseEntity.ok(savedTaxRate);
    }

    @GetMapping
    public ResponseEntity<List<TaxRate>> getAllTaxRates() {
        List<TaxRate> taxRates = taxRateService.getAllTaxRates();
        return ResponseEntity.ok(taxRates);
    }

    @GetMapping("/{categorie}")
    public Double getTaxRateByCategorie(@PathVariable("categorie") String categorie) {
        if (taxRateService.getTaxRateByCategorie(categorie).isPresent()){
            return taxRateService.getTaxRateByCategorie(categorie).get().getTaux();
        }else return -1.0;
    }



    @PutMapping("/{id}")
    public ResponseEntity<TaxRate> updateTaxRate( @RequestBody TaxRate taxRate) {
        TaxRate updatedTaxRate = taxRateService.updateTaxRate(taxRate);
        return ResponseEntity.ok(updatedTaxRate);
    }

    @DeleteMapping("/{categorie}")
    public ResponseEntity<Void> deleteTaxRate(@PathVariable String categorie) {
        taxRateService.deleteTaxRate(categorie);
        return ResponseEntity.ok().build();
    }
}
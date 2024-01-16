package com.tnb.taxcalculationservice.controllers;


import com.tnb.taxcalculationservice.services.TaxCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calcul")
public class TaxCalculatorController {

    private final TaxCalculationService taxCalculationService;

    @Autowired
    public TaxCalculatorController(TaxCalculationService taxCalculationService) {
        this.taxCalculationService = taxCalculationService;
    }


    @GetMapping("/{id}")
    public Double getTaxValue(@PathVariable("id") Long id){
        return  taxCalculationService.calculateTax(id);
    }



}

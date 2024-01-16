package com.tnb.terrainservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tax-rate-service", url = "http://localhost:8091")
public interface TaxRateClient {

    @GetMapping("/api/taxrates/{categorie}")
    Double getTaxRateByCategorie(@PathVariable("categorie") String categorie);
}


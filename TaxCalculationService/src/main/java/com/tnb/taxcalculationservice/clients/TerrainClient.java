package com.tnb.taxcalculationservice.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "terrain-service", url = "http://localhost:8090")
public interface TerrainClient {
    @GetMapping("/api/terrains/categorie/{id}")
    String getCategorieById(@PathVariable("id") Long id);
    @GetMapping("/api/terrains/surface/{id}")
    Double getSurfaceById(@PathVariable("id") Long id);
}

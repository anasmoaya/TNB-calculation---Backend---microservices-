package com.tnb.taxrateservice.repositories;

import com.tnb.taxrateservice.entities.TaxRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaxRateRepository extends JpaRepository<TaxRate, String> {
}
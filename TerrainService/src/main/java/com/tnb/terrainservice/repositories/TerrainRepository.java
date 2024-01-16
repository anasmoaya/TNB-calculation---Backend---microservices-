package com.tnb.terrainservice.repositories;

import com.tnb.terrainservice.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TerrainRepository extends JpaRepository<Terrain, Long> {

    @Query("SELECT t FROM Terrain t WHERE t.proprietaire.cin = ?1")
    List<Terrain> findByCinProprietaire(String cin);



}
package com.tnb.terrainservice.repositories;

import com.tnb.terrainservice.entities.Proprietaire;
import com.tnb.terrainservice.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {

}
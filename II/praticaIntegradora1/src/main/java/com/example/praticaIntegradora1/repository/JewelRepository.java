package com.example.praticaIntegradora1.repository;

import com.example.praticaIntegradora1.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Integer> {
}

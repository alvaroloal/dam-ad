package com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}



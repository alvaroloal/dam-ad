package com.salesianostriana.dam.lorentealmanalvarorestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Restaurante;
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}



package com.salesianostriana.dam.lorentealmanalvarorestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}

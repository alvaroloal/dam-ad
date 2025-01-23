package com.salesianos.triana.dam.ejercicio03.repository;

import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
//buscar bicicleta por nombre de marca
List<Bicicleta> findByMarca(String marca);


}

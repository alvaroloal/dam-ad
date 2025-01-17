package com.salesianostriana.dam.ejercicio02_modeladodatos.repo;

import com.salesianostriana.dam.ejercicio02_modeladodatos.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}

package com.salesianos.triana.apartado2.repository;

import com.salesianos.triana.apartado2.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository <Profesor, Long> {
}

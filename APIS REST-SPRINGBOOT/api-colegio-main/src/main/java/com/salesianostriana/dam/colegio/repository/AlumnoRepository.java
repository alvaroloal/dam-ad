package com.salesianostriana.dam.colegio.repository;

import com.salesianostriana.dam.colegio.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

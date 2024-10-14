package com.salesianostriana.dam.colegio_lorentealmanalvaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Curso;
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {}


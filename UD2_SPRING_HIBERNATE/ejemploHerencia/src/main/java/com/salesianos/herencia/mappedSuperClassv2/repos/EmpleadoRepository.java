package com.salesianos.herencia.mappedSuperClassv2.repos;

import com.salesianos.herencia.mappedSuperClassv2.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}

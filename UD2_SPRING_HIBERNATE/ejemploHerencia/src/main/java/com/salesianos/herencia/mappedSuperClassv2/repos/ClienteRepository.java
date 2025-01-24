package com.salesianos.herencia.mappedSuperClassv2.repos;

import com.salesianos.herencia.mappedSuperClassv2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

package com.salesianos.herencia.singleTable.repos;

import com.salesianos.herencia.singleTable.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

}

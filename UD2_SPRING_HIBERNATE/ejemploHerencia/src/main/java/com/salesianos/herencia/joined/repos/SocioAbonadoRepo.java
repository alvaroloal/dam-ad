package com.salesianos.herencia.joined.repos;

import com.salesianos.herencia.joined.model.Socio;
import com.salesianos.herencia.joined.model.SocioAbonado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SocioAbonadoRepo extends JpaRepository<SocioAbonado, Long> {

}

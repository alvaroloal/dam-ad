package com.salesianos.herencia.joined.repos;

import com.salesianos.herencia.joined.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocioRepo extends JpaRepository<Socio, Long> {


}

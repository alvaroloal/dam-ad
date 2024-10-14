package com.salesianostriana.dam.colegio_lorentealmanalvaro.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Asignatura;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.repository.AsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura saveAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    
    public void deleteAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}

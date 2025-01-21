package com.salesianostriana.dam.ejercicio02_modeladodatos.service;

import com.salesianostriana.dam.ejercicio02_modeladodatos.model.Profesor;
import com.salesianostriana.dam.ejercicio02_modeladodatos.repo.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {

        List<Profesor> result = profesorRepository.findAll();

        if(result.isEmpty())
            throw new EntityNotFoundException();

        return result;
    }

    public Profesor save(Profesor profesor) {

        return profesorRepository.save(profesor);
    }

    public void delete(Long id) {

        profesorRepository.deleteById(id);
    }
}

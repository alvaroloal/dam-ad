package com.salesianostriana.dam.colegio_lorentealmanalvaro.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Alumno;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.repository.AlumnoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}


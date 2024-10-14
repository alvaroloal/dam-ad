package com.salesianostriana.dam.colegio_lorentealmanalvaro.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.MatriculaNotas;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.repository.MatriculaNotasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaNotasService {
    private final MatriculaNotasRepository matriculaNotasRepository;

    public MatriculaNotasService(MatriculaNotasRepository matriculaNotasRepository) {
        this.matriculaNotasRepository = matriculaNotasRepository;
    }

    public List<MatriculaNotas> getAllMatriculas() {
        return matriculaNotasRepository.findAll();
    }

    public Optional<MatriculaNotas> getMatriculaById(Long id) {
        return matriculaNotasRepository.findById(id);
    }

    public MatriculaNotas saveMatricula(MatriculaNotas matriculaNotas) {
        return matriculaNotasRepository.save(matriculaNotas);
    }

    public void deleteMatricula(Long id) {
        matriculaNotasRepository.deleteById(id);
    }
}


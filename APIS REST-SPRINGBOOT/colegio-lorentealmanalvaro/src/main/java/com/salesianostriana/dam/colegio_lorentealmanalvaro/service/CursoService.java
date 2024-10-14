package com.salesianostriana.dam.colegio_lorentealmanalvaro.service;


import org.springframework.stereotype.Service;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Curso;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.repository.CursoRepository;

import java.util.List;

import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}




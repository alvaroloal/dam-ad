package com.salesianostriana.dam.colegio_lorentealmanalvaro.controller;

import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.MatriculaNotas;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.service.MatriculaNotasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaNotasController {

    private final MatriculaNotasService matriculaNotasService;

    public MatriculaNotasController(MatriculaNotasService matriculaNotasService) {
        this.matriculaNotasService = matriculaNotasService;
    }

    @GetMapping
    public List<MatriculaNotas> getAllMatriculas() {
        return matriculaNotasService.getAllMatriculas();
    }

    @GetMapping("/{id}")
    public Optional<MatriculaNotas> getMatriculaById(@PathVariable Long id) {
        return matriculaNotasService.getMatriculaById(id);
    }

    @PostMapping
    public MatriculaNotas createMatricula(@RequestBody MatriculaNotas matricula) {
        return matriculaNotasService.saveMatricula(matricula);
    }

    @PutMapping("/{id}")
    public MatriculaNotas updateMatricula(@PathVariable Long id, @RequestBody MatriculaNotas matriculaDetails) {
        Optional<MatriculaNotas> matriculaOptional = matriculaNotasService.getMatriculaById(id);

        if (matriculaOptional.isPresent()) {
            MatriculaNotas matricula = matriculaOptional.get();
            matricula.setAño(matriculaDetails.getAño());
            matricula.setNota(matriculaDetails.getNota());
            return matriculaNotasService.saveMatricula(matricula);
        } else {
            throw new RuntimeException("Matrícula no encontrada con ID " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMatricula(@PathVariable Long id) {
        matriculaNotasService.deleteMatricula(id);
    }
}


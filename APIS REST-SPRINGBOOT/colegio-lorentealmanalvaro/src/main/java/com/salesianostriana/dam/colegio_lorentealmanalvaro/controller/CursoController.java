package com.salesianostriana.dam.colegio_lorentealmanalvaro.controller;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Curso;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Optional<Curso> cursoOptional = cursoService.getCursoById(id);

        if (cursoOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            curso.setNombre(cursoDetails.getNombre());
            curso.setTipo(cursoDetails.getTipo());
            return cursoService.saveCurso(curso);
        } else {
            throw new RuntimeException("Curso no encontrado con id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
}







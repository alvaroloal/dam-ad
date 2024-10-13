package com.salesianostriana.dam.colegio_lorentealmanalvaro.controller;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.dto.*;
import com.ejemplo.cursos.dto.CursoDTO;
import com.ejemplo.cursos.dto.AlumnoDTO;
import com.ejemplo.cursos.service.CursoService;
import com.ejemplo.cursos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/api/cursos")
    public List<CursoDTO> obtenerCursos() {
        return cursoService.obtenerCursos();
    }
}

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/api/alumnos")
    public List<AlumnoDTO> obtenerAlumnos() {
        return alumnoService.obtenerAlumnos();
    }
}



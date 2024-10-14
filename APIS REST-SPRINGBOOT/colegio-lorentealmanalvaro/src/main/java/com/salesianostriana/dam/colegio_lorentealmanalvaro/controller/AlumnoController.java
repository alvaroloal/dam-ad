package com.salesianostriana.dam.colegio_lorentealmanalvaro.controller;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Alumno;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.service.AlumnoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

   
    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

   
    @GetMapping("/{id}")
    public Optional<Alumno> getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id);
    }

    
    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }

    
    @PutMapping("/{id}")
    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Optional<Alumno> alumnoOptional = alumnoService.getAlumnoById(id);

        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            alumno.setNombre(alumnoDetails.getNombre());
            alumno.setApellidos(alumnoDetails.getApellidos());
            alumno.setDireccion(alumnoDetails.getDireccion());
            alumno.setTelefono(alumnoDetails.getTelefono());
            alumno.setEmail(alumnoDetails.getEmail());
            alumno.setFechaNac(alumnoDetails.getFechaNac());
            return alumnoService.saveAlumno(alumno);
        } else {
            throw new RuntimeException("Alumno no encontrado con ID " + id);
        }
    }

    
    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
    }
}

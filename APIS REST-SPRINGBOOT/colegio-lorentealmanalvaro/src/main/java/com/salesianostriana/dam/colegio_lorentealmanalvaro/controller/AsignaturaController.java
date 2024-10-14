package com.salesianostriana.dam.colegio_lorentealmanalvaro.controller;

import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.colegio_lorentealmanalvaro.model.Asignatura;
import com.salesianostriana.dam.colegio_lorentealmanalvaro.service.AsignaturaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.getAllAsignaturas();
    }

    @GetMapping("/{id}")
    public Optional<Asignatura> getAsignaturaById(@PathVariable Long id) {
        return asignaturaService.getAsignaturaById(id);
    }

    @PostMapping
    public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.saveAsignatura(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        Optional<Asignatura> asignaturaOptional = asignaturaService.getAsignaturaById(id);

        if (asignaturaOptional.isPresent()) {
            Asignatura asignatura = asignaturaOptional.get();
            asignatura.setNombre(asignaturaDetails.getNombre());
            asignatura.setNumHoras(asignaturaDetails.getNumHoras());
            asignatura.setContenidos(asignaturaDetails.getContenidos());
            return asignaturaService.saveAsignatura(asignatura);
        } else {
            throw new RuntimeException("Asignatura no encontrada con id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
    }
}


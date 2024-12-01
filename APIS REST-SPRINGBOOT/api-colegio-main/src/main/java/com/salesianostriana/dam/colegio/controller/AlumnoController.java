package com.salesianostriana.dam.colegio.controller;

import com.salesianostriana.dam.colegio.dto.GetAlumnoDto;
import com.salesianostriana.dam.colegio.model.Alumno;
import com.salesianostriana.dam.colegio.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;



    @GetMapping
    public ResponseEntity<List<GetAlumnoDto>> mostrarTodo() {

        List<Alumno> data = alumnoService.findAll();

        if(data.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<GetAlumnoDto> result =
                data.stream()
                        .map(GetAlumnoDto::of)
                        .toList();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

package com.salesianostriana.dam.colegio.controller;

import com.salesianostriana.dam.colegio.dto.GetCursoDto;
import com.salesianostriana.dam.colegio.model.Curso;
import com.salesianostriana.dam.colegio.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/curso")
public class CursoController {

    private final CursoService cursoService;


    @GetMapping
    public ResponseEntity<List<GetCursoDto>> mostrarTodos() {

        List<Curso> data = cursoService.findAll();

        if (data.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        List<GetCursoDto> response = data.stream()
                .map(GetCursoDto::of)
                .toList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

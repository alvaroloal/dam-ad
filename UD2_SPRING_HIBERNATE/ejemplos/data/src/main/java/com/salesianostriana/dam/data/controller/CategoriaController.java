package com.salesianostriana.dam.data.controller;

import com.salesianostriana.dam.data.dto.GetCategoriaDto;
import com.salesianostriana.dam.data.model.Categoria;
import com.salesianostriana.dam.data.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;


    @GetMapping
    public List<GetCategoriaDto> findAll() {

        return categoriaService.findAll()
                .stream()
                .map(GetCategoriaDto::of)
                .toList();
    }


    @GetMapping("{id}")
    public GetCategoriaDto findById(@PathVariable Long id) {

        return GetCategoriaDto.of(categoriaService.findById(id));
    }


    @PostMapping("{categoria}")
    public ResponseEntity<GetCategoriaDto> save(@PathVariable String categoria) {

        return ResponseEntity.status(HttpStatus.CREATED).body(GetCategoriaDto.of(categoriaService.save(categoria)));

    }

    @PutMapping("{id}/{categoria}")
    public GetCategoriaDto edit(@PathVariable Long id, @PathVariable String categoria) {


        return GetCategoriaDto.of(categoriaService.edit(Categoria.builder().nombre(categoria).build(), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        categoriaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}

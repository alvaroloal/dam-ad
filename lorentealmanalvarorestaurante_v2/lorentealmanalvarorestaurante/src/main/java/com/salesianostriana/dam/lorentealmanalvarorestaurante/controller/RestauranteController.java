package com.salesianostriana.dam.lorentealmanalvarorestaurante.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Restaurante;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.service.RestauranteService;

import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/place")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteServicio;

    // listar todos
    @GetMapping("/")
    public ResponseEntity<List<Restaurante>> listarTodos() {
        List<Restaurante> restaurantes = restauranteServicio.listarTodos();
        if (restaurantes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    // listar por id
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> listarPorId(@PathVariable Long id) {
        return restauranteServicio.listarPorId(id)
                .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // crear
    @PostMapping("/")
    public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante creado = restauranteServicio.crearRestaurante(restaurante);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // modificar
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> modificarRestaurante(@PathVariable Long id, @RequestBody Restaurante detallesRestaurante) {
        return restauranteServicio.modificarRestaurante(id, detallesRestaurante)
                .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // agregar tag a un restaurante
    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public ResponseEntity<Restaurante> agregarTag(@PathVariable("id") Long restauranteId, @PathVariable("nuevo_tag") String nuevoTag) {
        return restauranteServicio.agregarTag(restauranteId, nuevoTag)
                .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // eliminar tag de un restaurante
    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Restaurante> eliminarTag(@PathVariable Long id, @PathVariable String tag) {
        return restauranteServicio.eliminarTag(id, tag)
                .map(restaurante -> new ResponseEntity<>(restaurante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // eliminar restaurante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestaurante(@PathVariable Long id) {
        restauranteServicio.eliminarRestaurante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
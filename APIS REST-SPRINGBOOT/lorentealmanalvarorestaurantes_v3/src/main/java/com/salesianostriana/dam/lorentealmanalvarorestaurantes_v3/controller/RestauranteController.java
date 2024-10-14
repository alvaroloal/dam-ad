package com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Restaurante;
import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Tag;
import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.service.RestauranteService;

import java.util.List;

@RestController
@RequestMapping("/place")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurante>> listRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.listAll();
        return restaurantes.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> getRestaurante(@PathVariable Long id) {
        return restauranteService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Restaurante> createRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante savedRestaurante = restauranteService.create(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return ResponseEntity.ok(restauranteService.update(id, restaurante));
    }

    @PutMapping("/{id}/tag/add/{newTag}")
    public ResponseEntity<Restaurante> addTag(@PathVariable Long id, @PathVariable String newTag) {
        Tag tag = new Tag();
        tag.setNombre(newTag);
        return ResponseEntity.ok(restauranteService.addTag(id, tag));
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Restaurante> deleteTag(@PathVariable Long id, @PathVariable String tag) {
        return ResponseEntity.ok(restauranteService.deleteTag(id, tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        try {
            restauranteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

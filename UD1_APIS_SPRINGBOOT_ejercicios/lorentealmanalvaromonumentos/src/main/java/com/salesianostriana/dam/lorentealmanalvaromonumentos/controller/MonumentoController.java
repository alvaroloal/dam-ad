package com.salesianostriana.dam.lorentealmanalvaromonumentos.controller;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.service.MonumentoService;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monumentos")
public class MonumentoController {

    @Autowired // creo una instancia del servicio creado
    private MonumentoService monumentoService;

    // obtener todos los monumentos
    @GetMapping
    public List<Monumento> getAllMonumentos() {
        return monumentoService.getAllMonumentos();
    }

    // obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getMonumentoById(@PathVariable Long id) {
        Optional<Monumento> monumento = monumentoService.getMonumentoById(id);
        if (monumento.isPresent()) {
            return ResponseEntity.ok(monumento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // crear nuevo monumento
    @PostMapping
    public ResponseEntity<Monumento> createMonumento(@RequestBody Monumento monumento) {
        Monumento nuevoMonumento = monumentoService.createMonumento(monumento);
        return ResponseEntity.status(201).body(nuevoMonumento);
    }


    // actualizar monumento 
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> updateMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        if (monumentoService.getMonumentoById(id).isPresent()) {
            Monumento monumentoActualizado = monumentoService.updateMonumento(id, monumento);
            return ResponseEntity.ok(monumentoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    // eliminar monumento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonumento(@PathVariable Long id) {
        if (monumentoService.getMonumentoById(id).isPresent()) {
            monumentoService.deleteMonumento(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



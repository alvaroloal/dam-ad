package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.dto.GetMonumentoDto;
import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoService service;



    @GetMapping
    public ResponseEntity<List<GetMonumentoDto>> findAll
            (@RequestParam(required = false,
            value = "orden",
            defaultValue = "no")
             String orden) {

        List<Monumento> data = service.findAll(orden);
        if(data.isEmpty())
            return ResponseEntity.notFound().build();

        List<GetMonumentoDto> resp = data.stream()
                .map(GetMonumentoDto::of)
                .toList();

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMonumentoDto> findById(@PathVariable Long id) {

        return ResponseEntity.of(service.findById(id).map(GetMonumentoDto::of));
    }

    @PostMapping
    public ResponseEntity<GetMonumentoDto> save(@RequestBody Monumento monumento) {

        return ResponseEntity.status(HttpStatus.CREATED).body(GetMonumentoDto.of(service.save(monumento)));

    }

    @PutMapping("/{id}")
    public ResponseEntity<GetMonumentoDto> edit(@PathVariable Long id, @RequestBody Monumento monumento) {

        return ResponseEntity.of(service.edit(id, monumento).map(GetMonumentoDto::of));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.findById(id).ifPresent(service::delete);

        return ResponseEntity.noContent().build();
    }


}

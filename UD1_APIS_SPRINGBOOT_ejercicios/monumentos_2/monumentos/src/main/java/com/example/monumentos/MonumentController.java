package com.example.monumentos;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentController {

    private final MonumentRepository monumentRepository;


    @GetMapping
    public ResponseEntity<List<Monument>> getAllMonuments(
            @RequestParam(required = false, value = "countryName", defaultValue = "all") String monumentName,
            @RequestParam(required = false, value = "sort", defaultValue = "desc") String sortDirection) {
        List<Monument> result = monumentRepository.query(monumentName, sortDirection);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monument> getyBYId(@PathVariable Long id) {
        return ResponseEntity.of(monumentRepository.get(id));
    }

    @PostMapping
    public ResponseEntity<Monument> addMonument(@RequestBody Monument monument) {
        return ResponseEntity.status((HttpStatus.CREATED)).body(monumentRepository.add(monument));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monument> deleteMonument(@PathVariable Long id) {
        monumentRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monument> editMonument(@PathVariable Long id, @RequestBody Monument monument) {
        return ResponseEntity.of(monumentRepository.edit(id, monument));
    }
}

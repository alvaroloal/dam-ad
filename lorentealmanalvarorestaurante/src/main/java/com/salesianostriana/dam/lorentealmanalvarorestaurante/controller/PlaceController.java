package com.salesianostriana.dam.lorentealmanalvarorestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Place;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.repository.PlaceRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    public ResponseEntity<List<Place>> listPlaces() {
        List<Place> places = placeRepository.findAll();
        return places.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(null) : ResponseEntity.ok(places);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlace(@PathVariable Long id) {
        Optional<Place> place = placeRepository.findById(id);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place savedPlace = placeRepository.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlace);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (!optionalPlace.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        Place place = optionalPlace.get();
        place.setNombre(placeDetails.getNombre());
        place.setDireccion(placeDetails.getDireccion());
        place.setLatitud(placeDetails.getLatitud());
        place.setLongitud(placeDetails.getLongitud());
        place.setDescripcion(placeDetails.getDescripcion());
        place.setFotoUrl(placeDetails.getFotoUrl());

        placeRepository.save(place);
        return ResponseEntity.ok(place);
    }

    @PutMapping("/{id}/tag/add/{newTag}")
    public ResponseEntity<Place> addTag(@PathVariable Long id, @PathVariable String newTag) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (!optionalPlace.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Place place = optionalPlace.get();
        place.getTags().add(newTag);
        placeRepository.save(place);
        return ResponseEntity.ok(place);
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public ResponseEntity<Place> removeTag(@PathVariable Long id, @PathVariable String tag) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (!optionalPlace.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Place place = optionalPlace.get();
        place.getTags().remove(tag);
        placeRepository.save(place);
        return ResponseEntity.ok(place);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        if (placeRepository.existsById(id)) {
            placeRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }
}


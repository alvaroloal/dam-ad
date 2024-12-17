package com.salesianostriana.dam.resteval.controller;

import com.salesianostriana.dam.resteval.Place;
import com.salesianostriana.dam.resteval.dto.CreatePlaceDto;
import com.salesianostriana.dam.resteval.dto.GetPlaceListDto;
import com.salesianostriana.dam.resteval.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService service;


    @GetMapping
    public GetPlaceListDto findAll() {

        return GetPlaceListDto.of(service.findAll());
    }

    @GetMapping("/{id}")
    public Place findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody CreatePlaceDto place) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(place.to()));
    }

    @PutMapping("/{id}")
    public Place edit(@PathVariable Long id, @RequestBody CreatePlaceDto place) {

        return service.edit(id, place.to());
    }
    @PutMapping("/{id}/tag/add/{nuevo_tag}")
    public Place addTag(@PathVariable("id") Long id, @PathVariable("nuevo_tag") String nuevoTag) {

        return service.addTagToPlace(id, nuevoTag);
    }

    @PutMapping("/{id}/tag/del/{tag}")
    public Place removeTag(@PathVariable Long id, @PathVariable String tag) {

        Place place = service.findById(id);

        place.removeTag(tag);

        return service.edit(id, place);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

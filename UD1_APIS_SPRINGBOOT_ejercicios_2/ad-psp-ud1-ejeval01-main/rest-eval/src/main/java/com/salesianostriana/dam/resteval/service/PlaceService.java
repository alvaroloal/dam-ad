package com.salesianostriana.dam.resteval.service;

import com.salesianostriana.dam.resteval.Place;
import com.salesianostriana.dam.resteval.PlaceRepository;
import com.salesianostriana.dam.resteval.error.PlaceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository repository;

    public List<Place> findAll() {

        if(repository.getAll().isEmpty())
            throw new PlaceNotFoundException("No se han encontrado lugares");

        return repository.getAll();
    }

    public Place findById(Long id) {

        return repository.get(id).orElseThrow(() -> new PlaceNotFoundException("No se ha encontrado ningún lugar con el ID: %d".formatted(id)));
    }

    public Place save(Place place) {

        return repository.add(place);
    }

    public Place edit(Long id, Place place){

        return repository.edit(id, place)
                .orElseThrow(() -> new PlaceNotFoundException("No se ha encontrado ningún lugar con el ID: %d".formatted(id)));
    }

    public void delete(Long id) {

        repository.delete(id);
    }

    public Place addTagToPlace(Long idPlace, String tag) {

        Place place = repository.get(idPlace).orElseThrow(() -> new PlaceNotFoundException("No se ha encontrado ningún lugar con el ID: %d".formatted(idPlace)));

        place.addTag(tag);

        return repository.edit(idPlace, place).get();
    }
}

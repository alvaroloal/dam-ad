package com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.repository.TagRepository;
import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Restaurante;
import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.model.Tag;
import com.salesianostriana.dam.lorentealmanalvarorestaurantes_v3.repository.RestauranteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private TagRepository tagRepository;


    // todos
    public List<Restaurante> listAll() {
        return restauranteRepository.findAll();
    }
    //buscar por id
    public Optional<Restaurante> getById(Long id) {
        return restauranteRepository.findById(id);
    }


    //crear 
    public Restaurante create(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }


    //actualizar
    public Restaurante update(Long id, Restaurante restaurante) {
        Restaurante existingRestaurante = restauranteRepository.findById(id).orElseThrow();
        existingRestaurante.setName(restaurante.getName());
        existingRestaurante.setAddress(restaurante.getAddress());
        existingRestaurante.setLatitude(restaurante.getLatitude());
        existingRestaurante.setLongitude(restaurante.getLongitude());
        existingRestaurante.setDescription(restaurante.getDescription());
        existingRestaurante.setPhotoUrl(restaurante.getPhotoUrl());
        return restauranteRepository.save(existingRestaurante);
    }
    //agregar tag
    public Restaurante addTag(Long id, Tag newTag) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow();
        restaurante.getTags().add(newTag);
        return restauranteRepository.save(restaurante);
    }
    //eliminar tag
    public Restaurante deleteTag(Long id, String tagName) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow();
        Tag tagToRemove = restaurante.getTags().stream()
                .filter(tag -> tag.getName().equals(tagName))
                .findFirst()
                .orElseThrow();
        restaurante.getTags().remove(tagToRemove);
        return restauranteRepository.save(restaurante);
    }
    //eliminar restaurante
    public void delete(Long id) {
        if (!restauranteRepository.existsById(id)) {
            throw new RuntimeException("Restaurante no encontrado");
        }
        restauranteRepository.deleteById(id);
    }
}


package com.salesianostriana.dam.lorentealmanalvarorestaurante.service;

import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Restaurante;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.model.Tag;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.repository.RestauranteRepository;
import com.salesianostriana.dam.lorentealmanalvarorestaurante.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepositorio;

    @Autowired
    private TagRepository tagRepositorio;

    // todos los restaurantes
    public List<Restaurante> listarTodos() {
        return restauranteRepositorio.findAll();
    }

    // buscar por id
    public Optional<Restaurante> listarPorId(Long id) {
        return restauranteRepositorio.findById(id);
    }

    // crear restaurante
    public Restaurante crearRestaurante(Restaurante restaurante) {
        //
        Restaurante nuevoRestaurante = new Restaurante();
        nuevoRestaurante.setNombre(restaurante.getNombre());
        nuevoRestaurante.setCalle(restaurante.getCalle());
        nuevoRestaurante.setCiudad(restaurante.getCiudad());
        nuevoRestaurante.setLatitud(restaurante.getLatitud());
        nuevoRestaurante.setLongitud(restaurante.getLongitud());
        nuevoRestaurante.setDescripcion(restaurante.getDescripcion());
        nuevoRestaurante.setFotoUrl(restaurante.getFotoUrl());
        nuevoRestaurante.setTags(restaurante.getTags());
        
        return restauranteRepositorio.save(nuevoRestaurante);
    }

    // modificar restaurante
    public Optional<Restaurante> modificarRestaurante(Long id, Restaurante detallesRestaurante) {
        return restauranteRepositorio.findById(id).map(restaurante -> {
            restaurante.setNombre(detallesRestaurante.getNombre());
            restaurante.setCalle(detallesRestaurante.getCalle());
            restaurante.setCiudad(detallesRestaurante.getCiudad());
            restaurante.setLatitud(detallesRestaurante.getLatitud());
            restaurante.setLongitud(detallesRestaurante.getLongitud());
            restaurante.setDescripcion(detallesRestaurante.getDescripcion());
            restaurante.setFotoUrl(detallesRestaurante.getFotoUrl());
            return restauranteRepositorio.save(restaurante);
        });
    }

    // eliminar restaurante
    public boolean eliminarRestaurante(Long id) {
        return restauranteRepositorio.findById(id).map(restaurante -> {
            restauranteRepositorio.delete(restaurante);
            return true;
        }).orElse(false);
    }

    // agregar tag
    public Optional<Restaurante> agregarTag(Long restauranteId, String nombreTag) {
        Optional<Restaurante> restauranteOpt = restauranteRepositorio.findById(restauranteId);
        if (!restauranteOpt.isPresent()) {
            return Optional.empty();
        }

        Restaurante restaurante = restauranteOpt.get();
        Optional<Tag> tagOpt = tagRepositorio.findByNombre(nombreTag);
        if (!tagOpt.isPresent()) {
            Tag tag = new Tag(nombreTag);
            tagRepositorio.save(tag);
            restaurante.addTag(tag);          
        }else{
            restaurante.addTag(tagOpt.get());
        }
        restauranteRepositorio.save(restaurante);
        return Optional.of(restaurante);
    }

    // eliminar tag
    public Optional<Restaurante> eliminarTag(Long id, String nombreTag) {
        Optional<Restaurante> restauranteOpt = restauranteRepositorio.findById(id);
        if (!restauranteOpt.isPresent()) {
            return Optional.empty();
        }

        Restaurante restaurante = restauranteOpt.get();
        Optional<Tag> tagOpt = tagRepositorio.findByNombre(nombreTag);
        if (tagOpt.isPresent()) {
            restaurante.removeTag(tagOpt.get());
            restauranteRepositorio.save(restaurante);
        }
        return Optional.of(restaurante);
    }
}

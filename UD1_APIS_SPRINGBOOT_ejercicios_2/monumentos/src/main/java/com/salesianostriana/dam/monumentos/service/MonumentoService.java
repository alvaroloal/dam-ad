package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.error.MonumentoNoEncontradoException;
import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository repository;

    public List<Monumento> findAll(String orden) {

       if(orden.equalsIgnoreCase("asc"))
           return repository.findAllAsc();

       else if (orden.equalsIgnoreCase("desc"))
           return repository.findAllDesc();

       else if (repository.findAll().isEmpty())
           throw new MonumentoNoEncontradoException("No se han encontrado monumentos");

       return repository.findAll();
    }

    public Monumento findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new MonumentoNoEncontradoException(id));
    }

    public Monumento save(Monumento monumento) {

        return repository.save(monumento);
    }

    public Monumento edit(Long id, Monumento monumento) {

        Optional<Monumento> optionalMonumento = repository.findById(id);

        return optionalMonumento.map(m -> {
            m.setCodigoPais(monumento.getCodigoPais());
            m.setDescripcion(monumento.getDescripcion());
            m.setLatitud(monumento.getLatitud());
            m.setLongitud(monumento.getLongitud());
            m.setNombreMonumento(monumento.getNombreMonumento());
            m.setNombreCiudad(monumento.getNombreCiudad());
            m.setNombrePais(monumento.getNombrePais());
            m.setPhotoUrl(monumento.getPhotoUrl());
            return m;
        }).orElseThrow(() -> new MonumentoNoEncontradoException(id));
    }

    public void delete(Monumento monumento) {

        repository.delete(monumento);
    }


}

package com.salesianostriana.dam.lorentealmanalvaromonumentos.service;


import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.repository.MonumentoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoService {

    @Autowired
    private MonumentoRepository monumentoRepository;

    // obtener todos los monumetnos
    public List<Monumento> getAllMonumentos() {
        return this.monumentoRepository.findAll();
    }

    // obtener por id
    public Optional<Monumento> getMonumentoById(Long id) {
        return monumentoRepository.findById(id);
    }

    // crear un monumento
    public Monumento createMonumento(Monumento monumento) {
        return monumentoRepository.save(monumento);
    }

    // actualizar monumento existente
    public Monumento updateMonumento(Long id, Monumento monumento) {
        monumento.setId(id); // asegurar que el id no cambia
        return monumentoRepository.save(monumento);
    }

    // eliminar monumento
    public void deleteMonumento(Long id) {
        monumentoRepository.deleteById(id);
    }
}



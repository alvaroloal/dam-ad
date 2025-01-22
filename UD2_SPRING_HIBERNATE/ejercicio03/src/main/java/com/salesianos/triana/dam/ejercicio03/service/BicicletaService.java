package com.salesianos.triana.dam.ejercicio03.service;



import com.salesianos.triana.dam.ejercicio03.dto.EditBici;
import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;
import com.salesianos.triana.dam.ejercicio03.repository.BicicletaRepository;
import com.salesianos.triana.dam.ejercicio03.repository.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;

    public List<Bicicleta> findAll() {
        List<Bicicleta> result = bicicletaRepository.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay bicicletas con esos criterios de búsqueda");
        return result;
    }

    public Bicicleta findById(Long id) {
        return bicicletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ id));
    }

    public Bicicleta save(EditBici nuevo) {
        return bicicletaRepository.save(Bicicleta.builder()
                .marca(nuevo.marca())
                .modelo(nuevo.modelo())
                .estado(nuevo.estado())
                .estacion(estacionRepository.findById(nuevo.estacionId())
                        .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ nuevo.estacionId())))
                .build());
    }

    public Bicicleta edit(EditBici editBiciCmd, Long id) {
        return bicicletaRepository.findById(id)
                .map(old -> {
                    old.setMarca(editBiciCmd.marca());
                    old.setModelo(editBiciCmd.modelo());
                    old.setEstado(editBiciCmd.estado());
                    old.setEstacion(estacionRepository.findById(editBiciCmd.estacionId())
                            .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ editBiciCmd.estacionId())));
                    return bicicletaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay bicicleta con ID: "+ id));

    }

    public void delete(Long id) {
        bicicletaRepository.deleteById(id);
    }

}

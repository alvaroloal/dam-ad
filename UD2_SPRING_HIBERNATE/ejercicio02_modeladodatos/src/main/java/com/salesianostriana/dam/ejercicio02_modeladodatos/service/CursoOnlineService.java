package com.salesianostriana.dam.ejercicio02_modeladodatos.service;

import com.salesianostriana.dam.ejercicio02_modeladodatos.model.CursoOnline;
import com.salesianostriana.dam.ejercicio02_modeladodatos.repo.CursoOnlineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoOnlineService {

    private final CursoOnlineRepository cursoOnlineRepository;

    public List<CursoOnline> findAll() {

        List<CursoOnline> result = cursoOnlineRepository.findAll();

        if(result.isEmpty())
            throw new EntityNotFoundException();

        return result;
    }

    public CursoOnline save(CursoOnline cursoOnline) {

        return cursoOnlineRepository.save(cursoOnline);
    }

    public void delete (Long id) {

        cursoOnlineRepository.deleteById(id);
    }
}

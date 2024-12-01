package com.salesianostriana.dam.colegio.service;

import com.salesianostriana.dam.colegio.model.Curso;
import com.salesianostriana.dam.colegio.repository.CursoRepository;
import com.salesianostriana.dam.colegio.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends BaseServiceImpl<Curso, Long, CursoRepository> {
}

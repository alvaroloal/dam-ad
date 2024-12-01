package com.salesianostriana.dam.colegio.service;

import com.salesianostriana.dam.colegio.model.MatriculaNotas;
import com.salesianostriana.dam.colegio.model.MatriculaNotasPK;
import com.salesianostriana.dam.colegio.repository.MatriculaNotasRepository;
import com.salesianostriana.dam.colegio.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MatriculaNotasService extends BaseServiceImpl<MatriculaNotas, MatriculaNotasPK, MatriculaNotasRepository> {
}

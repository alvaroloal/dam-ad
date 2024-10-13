package com.salesianostriana.dam.colegio_lorentealmanalvaro.service;

import com.ejemplo.cursos.dto.CursoDTO;
import com.ejemplo.cursos.dto.AlumnoDTO;
import com.ejemplo.cursos.model.Curso;
import com.ejemplo.cursos.model.Alumno;
import com.ejemplo.cursos.repository.CursoRepository;
import com.ejemplo.cursos.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> obtenerCursos() {
        return cursoRepository.findAll().stream().map(this::convertirCursoADTO).collect(Collectors.toList());
    }

    private CursoDTO convertirCursoADTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setTipo(curso.getTipo().name());
        dto.setHorasTotales(curso.getAsignaturas().stream().mapToInt(a -> a.getNumHoras()).sum());
        dto.setAsignaturas(curso.getAsignaturas().stream().map(asig -> {
            AsignaturaDTO asigDto = new AsignaturaDTO();
            asigDto.setId(asig.getId());
            asigDto.setNombre(asig.getNombre());
            asigDto.setNumHoras(asig.getNumHoras());
            asigDto.setCantidadAlumnos(asig.getMatriculas().size());
            return asigDto;
        }).collect(Collectors.toList()));
        return dto;
    }
}

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<AlumnoDTO> obtenerAlumnos() {
        return alumnoRepository.findAll().stream().map(this::convertirAlumnoADTO).collect(Collectors.toList());
    }

    private AlumnoDTO convertirAlumnoADTO(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getCodAlumno());
        dto.setNombreCompleto(alumno.getNombre() + " " + alumno.getApellidos());
        dto.setEdadA31Diciembre(2024 - alumno.getFechaNac().getYear());
        dto.setAsignaturas(alumno.getMatriculas().stream().map(m -> m.getAsignatura().getNombre()).collect(Collectors.toList()));
        return dto;
    }
}


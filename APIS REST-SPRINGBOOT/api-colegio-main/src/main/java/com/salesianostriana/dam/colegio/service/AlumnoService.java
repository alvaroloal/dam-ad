package com.salesianostriana.dam.colegio.service;

import com.salesianostriana.dam.colegio.model.Alumno;
import com.salesianostriana.dam.colegio.repository.AlumnoRepository;
import com.salesianostriana.dam.colegio.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoService extends BaseServiceImpl<Alumno, Long, AlumnoRepository> {

    public Alumno edit(Long id, Alumno alumno) {

        Optional<Alumno> optionalAlumno = repository.findById(id);

        if(optionalAlumno.isEmpty())
            return null;


        Alumno antiguo = optionalAlumno.get();

        antiguo.setNombre(alumno.getNombre());
        antiguo.setApellidos(alumno.getApellidos());
        antiguo.setEmail(alumno.getEmail());
        antiguo.setDireccion(alumno.getDireccion());
        antiguo.setFechaNac(alumno.getFechaNac());
        antiguo.setTelefono(alumno.getTelefono());

        return repository.save(antiguo);
    }
}

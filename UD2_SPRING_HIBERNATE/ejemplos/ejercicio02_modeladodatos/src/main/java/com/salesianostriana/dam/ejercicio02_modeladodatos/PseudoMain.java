package com.salesianostriana.dam.ejercicio02_modeladodatos;

import com.salesianostriana.dam.ejercicio02_modeladodatos.model.CursoOnline;
import com.salesianostriana.dam.ejercicio02_modeladodatos.model.Profesor;
import com.salesianostriana.dam.ejercicio02_modeladodatos.model.Video;
import com.salesianostriana.dam.ejercicio02_modeladodatos.service.CursoOnlineService;
import com.salesianostriana.dam.ejercicio02_modeladodatos.service.ProfesorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PseudoMain {

    private final ProfesorService profesorService;
    private final CursoOnlineService cursoOnlineService;


    @PostConstruct
    public void init() {

        Profesor profesor1 = Profesor.builder()
                .nombre("Ana Pérez")
                .email("ana.perez@triana.salesianos.edu")
                .puntuacion(9)
                .build();

        CursoOnline cursoOnline1 = CursoOnline.builder()
                .nombre("Curso de Angular avanzado")
                .puntuacion(8)
                .build();

        Video video1 = Video.builder()
                .url("angular-video1.mp4")
                .orden("1")
                .titulo("Configuración del entorno")
                .descripcion("Configuración inicial para trabajar con Angular")
                .build();
        Video video2 = Video.builder()
                .url("angular-video2.mp4")
                .orden("2")
                .titulo("Componentes avanzados")
                .descripcion("Introducción al uso de componentes avanzados en Angular")
                .build();

        cursoOnline1.addVideo(video1);
        cursoOnline1.addVideo(video2);

        profesor1.addCurso(cursoOnline1);

        profesorService.save(profesor1);
        cursoOnlineService.save(cursoOnline1);

        profesorService.findAll().forEach(System.out::println);

    }
}

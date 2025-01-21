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
                .nombre("Pepe")
                .email("pepe@triana.salesianos.edu")
                .puntuacion(10)
                .build();

        CursoOnline cursoOnline1 = CursoOnline.builder()
                .nombre("Curso Spring desde 0")
                .puntuacion(10)
                .build();

        Video video1 = Video.builder()
                .url("video1.mp4")
                .orden("1")
                .titulo("Spring desde cero")
                .descripcion("Introducción a Spring desde 0")
                .build();
        Video video2 = Video.builder()
                .url("video2.mp4")
                .orden("2")
                .titulo("Anotaciones")
                .descripcion("Introducción a anotaciones de Spring")
                .build();

        cursoOnline1.addVideo(video1);
        cursoOnline1.addVideo(video2);

        profesor1.addCurso(cursoOnline1);

        profesorService.save(profesor1);
        cursoOnlineService.save(cursoOnline1);

        profesorService.findAll().forEach(System.out::println);

    }
}

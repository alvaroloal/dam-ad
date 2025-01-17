package com.salesianos.triana.apartado2.util;

import com.salesianos.triana.apartado2.model.CursoOnline;
import com.salesianos.triana.apartado2.model.Profesor;
import com.salesianos.triana.apartado2.model.Video;
import com.salesianos.triana.apartado2.repository.CursoOnlineRepository;
import com.salesianos.triana.apartado2.repository.ProfesorRepository;
import com.salesianos.triana.apartado2.repository.VideoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataSeed{

    private ProfesorRepository profesorRepository;
    private CursoOnlineRepository cursoOnlineRepository;
    private VideoRepository videoRepository;

    @PostConstruct
    public void run(String... args) throws Exception {

        Profesor profesor = new Profesor();
        profesor.setNombre("Juan Pérez");
        profesor.setEmail("juan.perez@example.com");
        profesor.setPuntuacion(4.8);


        CursoOnline curso1 = new CursoOnline();
        curso1.setNombre("Introducción a Java");
        curso1.setPuntuacion(4.5);
        curso1.setProfesor(profesor);

        CursoOnline curso2 = new CursoOnline();
        curso2.setNombre("Spring Boot Avanzado");
        curso2.setPuntuacion(4.7);
        curso2.setProfesor(profesor);


        profesor.setCursos(Arrays.asList(curso1, curso2));


        Video video1 = new Video();
        video1.setOrden(1);
        video1.setTitulo("Introducción");
        video1.setDescripcion("Primera lección del curso de Java.");
        video1.setUrl("http://example.com/intro-java");
        video1.setCurso(curso1);

        Video video2 = new Video();
        video2.setOrden(2);
        video2.setTitulo("Sintaxis básica");
        video2.setDescripcion("Lección sobre la sintaxis de Java.");
        video2.setUrl("http://example.com/sintaxis-java");
        video2.setCurso(curso1);


        curso1.setVideos(Arrays.asList(video1, video2));


        profesorRepository.save(profesor);


    }
}


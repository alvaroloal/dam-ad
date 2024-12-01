package com.salesianostriana.dam.colegio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codAlumno;

    private String nombre, apellidos, direccion;

    @Column(length = 12)
    private String telefono;

    private String email;

    @DateTimeFormat(style = "dd/MM/yyyy")
    private LocalDate fechaNac;


    @OneToMany(mappedBy = "alumno", fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<MatriculaNotas> notas = new ArrayList<>();


}

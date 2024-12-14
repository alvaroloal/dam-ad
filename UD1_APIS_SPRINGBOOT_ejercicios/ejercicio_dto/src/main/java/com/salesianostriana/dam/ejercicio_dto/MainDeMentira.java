package com.salesianostriana.dam.ejercicio_dto;

import com.salesianostriana.dam.ejercicio_dto.alumno.Alumno;
import com.salesianostriana.dam.ejercicio_dto.alumno.AlumnoDTO;
import com.salesianostriana.dam.ejercicio_dto.alumno.Curso;
import com.salesianostriana.dam.ejercicio_dto.alumno.Direccion;
import com.salesianostriana.dam.ejercicio_dto.producto.Categoria;
import com.salesianostriana.dam.ejercicio_dto.producto.Producto;
import com.salesianostriana.dam.ejercicio_dto.producto.ProductoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainDeMentira {

    @PostConstruct
    public void init() {

        Direccion direccion = Direccion.builder().id(1L).tipoVia("Calle").linea1("San Jacinto").linea2("nº11").cp("41010").poblacion("Sevilla").provincia("Sevilla").build();
        Direccion direccion2 = Direccion.builder().id(2L).tipoVia("Calle").linea1("Condes de Bustillo").linea2("nº9").cp("41010").poblacion("Sevilla").provincia("Sevilla").build();
        Direccion direccion3 = Direccion.builder().id(2L).tipoVia("Plaza").linea1("Pedro Santos Gomez").linea2("nº11").cp("41010").poblacion("Sevilla").provincia("Sevilla").build();

        Curso curso = Curso.builder().id(1L).nombre("1ºDAM").tipo("Tecnológico").tutor("Miguel Campos Rivera").aula("Aula de primero de DAM").build();
        Curso curso2 = Curso.builder().id(2L).nombre("2ºDAM").tipo("Tecnológico").tutor("Luismi López Magaña").aula("Aula de segundo de DAM").build();

        Alumno alumno = Alumno.builder().id(1L).nombre("Alvaro").apellido1("Lorente").apellido2("Almán").telefono("675488833").email("alvaro@gmail.com").direccion(direccion).curso(curso).build();
        Alumno alumno2 = Alumno.builder().id(2L).nombre("Salvador").apellido1("Alonso").apellido2("Ruiz").telefono("675488833").email("salvador@gmail.com").direccion(direccion2).curso(curso2).build();
        Alumno alumno3 = Alumno.builder().id(3L).nombre("Belen").apellido1("Perez").apellido2("Benito").telefono("675488833").email("belen@gmail.com").direccion(direccion3).curso(curso).build();
        Alumno alumno4 = Alumno.builder().id(4L).nombre("Adara").apellido1("Fernandez").apellido2("Reyes").telefono("675488833").email("adara@gmail.com").direccion(direccion2).curso(curso2).build();

        System.out.println();

        System.out.println("Lista alumnos: ");
        System.out.println(AlumnoDTO.of(alumno));
        System.out.println(AlumnoDTO.of(alumno2));
        System.out.println(AlumnoDTO.of(alumno3));
        System.out.println(AlumnoDTO.of(alumno4));
        System.out.println();

        Categoria categoria = Categoria.builder().id(1L).nombre("Smartphones").build();
        Categoria categoria2 = Categoria.builder().id(2L).nombre("Laptops").build();

        Producto producto = Producto.builder().id(1L).nombre("iPhone 16 128GB").desc("Lo principal. iOS 18. Personal en cada detalle. Presentamos el iPhone 16").pvp(959.00).imagenes(List.of("https://thumb.pccomponentes.com/w-530-530/articles/1085/10855021/1149-apple-iphone-16-128gb-negro.jpg")).categoria(categoria).build();
        Producto producto2 = Producto.builder().id(2L).nombre("iPhone 16 Pro Max 256GB").desc("Resistente. Imponente. Titánico. El impresionante diseño del iPhone 16 Pro Max, fabricado en titanio de grado 5, estrena un nuevo acabado microgranallado, pulido hasta la perfección.").pvp(1469.00).imagenes(List.of("https://thumb.pccomponentes.com/w-530-530/articles/1085/10855067/1329-apple-iphone-16-pro-max-256gb-titanio-negro-libre-5dfb3113-a8b5-4758-a121-0eacb340e139.jpg")).categoria(categoria).build();
        Producto producto3 = Producto.builder().id(3L).nombre("MacBook Pro Apple M4 Pro").desc(" El MacBook Pro incorpora la gama más avanzada de chips que se ha creado nunca para un portátil profesional.").pvp(2449.00).imagenes(List.of("https://thumb.pccomponentes.com/w-530-530/articles/1086/10861539/1870-apple-macbook-pro-apple-m4-pro-12-nucleos-24gb-512gb-ssd-gpu-16-nucleos-14-plata.jpg")).categoria(categoria2).build();
        Producto producto4 = Producto.builder().id(4L).nombre("MacBook Air Apple M3").desc(" El MacBook Pro incorpora la gama más avanzada de chips que se ha creado nunca para un portátil profesional.").pvp(1449.00).imagenes(List.of("https://thumb.pccomponentes.com/w-530-530/articles/1081/10819872/129-apple-macbook-air-apple-m3-16gb-512gb-ssd-gpu-10-nucleos-136-blanco-estrella-2213c1fb-df7c-4ac5-8367-96eb7dc1c861.jpg")).categoria(categoria2).build();

        System.out.println("Lista productos: ");
        System.out.println(ProductoDTO.of(producto));
        System.out.println(ProductoDTO.of(producto2));
        System.out.println(ProductoDTO.of(producto3));
        System.out.println(ProductoDTO.of(producto4));
        System.out.println();
    }
}

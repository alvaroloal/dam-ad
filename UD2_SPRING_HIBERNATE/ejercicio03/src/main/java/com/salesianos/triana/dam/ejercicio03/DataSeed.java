package com.salesianos.triana.dam.ejercicio03;

import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;
import com.salesianos.triana.dam.ejercicio03.model.Estacion;
import com.salesianos.triana.dam.ejercicio03.model.Uso;
import com.salesianos.triana.dam.ejercicio03.model.Usuario;
import com.salesianos.triana.dam.ejercicio03.repository.BicicletaRepository;
import com.salesianos.triana.dam.ejercicio03.repository.EstacionRepository;
import com.salesianos.triana.dam.ejercicio03.repository.UsoRepository;
import com.salesianos.triana.dam.ejercicio03.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final EstacionRepository estacionRepository;
    private final BicicletaRepository bicicletaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsoRepository usoRepository;

    @PostConstruct
    public void run() {
        // estaciones
        Estacion estacion1 = Estacion.builder()
                .numero(1L)
                .nombre("Estacion Central")
                .coordenadas("40.7128, -74.0060")
                .capacidad(12)
                .build();

        Estacion estacion2 = Estacion.builder()
                .numero(2L)
                .nombre("Estacion Sur")
                .coordenadas("34.0522, -118.2437")
                .capacidad(20)
                .build();

        Estacion estacion3 = Estacion.builder()
                .numero(3L)
                .nombre("Estacion Este")
                .coordenadas("51.5074, -0.1278")
                .capacidad(18)
                .build();

        estacionRepository.save(estacion1);
        estacionRepository.save(estacion2);
        estacionRepository.save(estacion3);

        // bicicletas asociarlas con estaciones
        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("MarcaZ")
                .modelo("ModeloX")
                .estado("Disponible")
                .build();

        Bicicleta bicicleta2 = Bicicleta.builder()
                .marca("MarcaW")
                .modelo("ModeloY")
                .estado("En mantenimiento")
                .build();

        Bicicleta bicicleta3 = Bicicleta.builder()
                .marca("MarcaV")
                .modelo("ModeloZ")
                .estado("Disponible")
                .build();

        estacion1.addBicicleta(bicicleta1);
        estacion2.addBicicleta(bicicleta2);
        estacion3.addBicicleta(bicicleta3);

        bicicletaRepository.save(bicicleta1);
        bicicletaRepository.save(bicicleta2);
        bicicletaRepository.save(bicicleta3);
        estacionRepository.save(estacion1);
        estacionRepository.save(estacion2);
        estacionRepository.save(estacion3);

        // usuarios
        Usuario usuario1 = Usuario.builder()
                .nombre("Carlos Garcia")
                .numTarjeta(1111222233334444L)
                .pin(1111)
                .saldo(75.0)
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Lucia Fernandez")
                .numTarjeta(5555666677778888L)
                .pin(2222)
                .saldo(120.0)
                .build();

        Usuario usuario3 = Usuario.builder()
                .nombre("Ana Martinez")
                .numTarjeta(9999000011112222L)
                .pin(3333)
                .saldo(60.0)
                .build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);

        // crear usos - asociaciones
        Uso uso1 = Uso.builder()
                .fechaInicio(LocalDate.of(2025, 1, 18))
                .fechaFin(LocalDate.of(2025, 1, 18))
                .coste(8.0)
                .build();

        Uso uso2 = Uso.builder()
                .fechaInicio(LocalDate.of(2025, 1, 19))
                .fechaFin(LocalDate.of(2025, 1, 19))
                .coste(10.0)
                .build();

        Uso uso3 = Uso.builder()
                .fechaInicio(LocalDate.of(2025, 1, 20))
                .fechaFin(LocalDate.of(2025, 1, 12))
                .coste(0.0)
                .build();

        // asociaciones bidireccionales con Uso
        usuario1.addUso(uso1);
        bicicleta1.addUso(uso1);
        estacion1.addUso(uso1);


        usuario2.addUso(uso2);
        bicicleta2.addUso(uso2);
        estacion2.addUso(uso2);


        usuario3.addUso(uso3);
        bicicleta3.addUso(uso3);
        estacion3.addUso(uso3);

        usoRepository.save(uso1);
        usoRepository.save(uso2);
        usoRepository.save(uso3);
        System.out.println();
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        System.out.println();

        System.out.println(uso1);
        System.out.println(uso2);
        System.out.println(uso3);
        System.out.println();

        System.out.println(bicicleta1);
        System.out.println(bicicleta2);
        System.out.println(bicicleta3);
        System.out.println();

        System.out.println(estacion1);
        System.out.println(estacion2);
        System.out.println(estacion3);
        System.out.println();
    }
}

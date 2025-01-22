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
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final EstacionRepository estacionRepository;
    private final BicicletaRepository bicicletaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsoRepository usoRepository;

    @PostConstruct
    public void init() {
        Usuario usuario1 = Usuario.builder()
                .nombre("Carlos Garcia")
                .numTarjeta("1111222233334444")
                .pin("1111")
                .saldo("40.0")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Laura Martinez")
                .numTarjeta("5555666677778888")
                .pin("2222")
                .saldo("60.0")
                .build();

        Usuario usuario3 = Usuario.builder()
                .nombre("Miguel Torres")
                .numTarjeta("9999000011112222")
                .pin("3333")
                .saldo("70.0")
                .build();

        Usuario usuario4 = Usuario.builder()
                .nombre("Sofia Ramirez")
                .numTarjeta("1234432112344321")
                .pin("4444")
                .saldo("80.0")
                .build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario4);

        Estacion estacion1 = Estacion.builder()
                .numero(1)
                .nombre("Estacion Central")
                .coordenadas("40.416775,-3.703790")
                .capacidad(10)
                .build();

        Estacion estacion2 = Estacion.builder()
                .numero(2)
                .nombre("Estacion Norte")
                .coordenadas("40.452085,-3.688530")
                .capacidad(15)
                .build();

        Estacion estacion3 = Estacion.builder()
                .numero(3)
                .nombre("Estacion Sur")
                .coordenadas("40.382596,-3.684320")
                .capacidad(12)
                .build();

        Estacion estacion4 = Estacion.builder()
                .numero(4)
                .nombre("Estacion Este")
                .coordenadas("40.427500,-3.669600")
                .capacidad(8)
                .build();

        estacionRepository.save(estacion1);
        estacionRepository.save(estacion2);
        estacionRepository.save(estacion3);
        estacionRepository.save(estacion4);

        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("Orbea")
                .modelo("Occam")
                .estado("Disponible")
                .estacion(estacion1)
                .build();

        Bicicleta bicicleta2 = Bicicleta.builder()
                .marca("Giant")
                .modelo("Anthem")
                .estado("Disponible")
                .estacion(estacion2)
                .build();

        Bicicleta bicicleta3 = Bicicleta.builder()
                .marca("Trek")
                .modelo("Marlin 5")
                .estado("Disponible")
                .estacion(estacion3)
                .build();

        Bicicleta bicicleta4 = Bicicleta.builder()
                .marca("Specialized")
                .modelo("Rockhopper")
                .estado("Disponible")
                .estacion(estacion4)
                .build();

        bicicletaRepository.save(bicicleta1);
        bicicletaRepository.save(bicicleta2);
        bicicletaRepository.save(bicicleta3);
        bicicletaRepository.save(bicicleta4);

        Uso uso1 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(1))
                .fechaFin(LocalDateTime.now())
                .coste(5.0)
                .usuario(usuario1)
                .bicicleta(bicicleta1)
                .estacionFinal(estacion2)
                .build();

        Uso uso2 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(2))
                .fechaFin(LocalDateTime.now().minusHours(1))
                .coste(3.0)
                .usuario(usuario2)
                .bicicleta(bicicleta2)
                .estacionFinal(estacion1)
                .build();

        Uso uso3 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(3))
                .fechaFin(LocalDateTime.now().minusHours(2))
                .coste(7.0)
                .usuario(usuario3)
                .bicicleta(bicicleta3)
                .estacionFinal(estacion4)
                .build();

        Uso uso4 = Uso.builder()
                .fechaInicio(LocalDateTime.now().minusHours(4))
                .fechaFin(LocalDateTime.now().minusHours(3))
                .coste(4.5)
                .usuario(usuario4)
                .bicicleta(bicicleta4)
                .estacionFinal(estacion3)
                .build();

        usoRepository.save(uso1);
        usoRepository.save(uso2);
        usoRepository.save(uso3);
        usoRepository.save(uso4);

        System.out.println();
        System.out.println("Usuarios " + usuarioRepository.findAll());
        System.out.println();
        System.out.println("Estaciones " + estacionRepository.findAll());
        System.out.println();
        System.out.println("Bicicletas " + bicicletaRepository.findAll());
        System.out.println();
        System.out.println("Usos " + usoRepository.findAll());
        System.out.println();
    }
}

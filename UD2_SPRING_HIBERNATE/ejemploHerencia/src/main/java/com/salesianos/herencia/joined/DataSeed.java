package com.salesianos.herencia.joined;

import com.salesianos.herencia.joined.model.Socio;
import com.salesianos.herencia.joined.model.SocioAbonado;
import com.salesianos.herencia.joined.repos.SocioAbonadoRepo;
import com.salesianos.herencia.joined.repos.SocioRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataSeed {

    private final SocioRepo socioRepository;
    private final SocioAbonadoRepo socioAbonadoRepository;

    @PostConstruct
    public void init() {

        Socio socio1 = Socio.builder()
                .nombre("José")
                .apellidos("Lopez")
                .email("antonio@gmail.com")
                .telefono("123456789")
                .dni("12345678A")
                .fechaNacimiento(java.time.LocalDate.of(1993, 4, 1))
                .fechaSocio(java.time.LocalDate.of(2023, 1, 1))
                .cuota(50.0)
                .build();

        Socio socio2 = Socio.builder()
                .nombre("Pilar")
                .apellidos("Alonso")
                .email("pilar@gmail.com")
                .telefono("987654321")
                .dni("87654321B")
                .fechaNacimiento(java.time.LocalDate.of(1999, 1, 1))
                .fechaSocio(java.time.LocalDate.of(2021, 1, 1))
                .cuota(30.0)
                .build();

        socioRepository.save(socio1);
        socioRepository.save(socio2);

        SocioAbonado socioAbonado1 = SocioAbonado.builder()
                .nombre("Jose")
                .apellidos("Perez")
                .email("joseperez@gmail.com")
                .telefono("123456789")
                .dni("12345678A")
                .asiento("A1")
                .fechaAbono("2021-01-01")
                .build();

        SocioAbonado socioAbonado2 = SocioAbonado.builder()
                .nombre("Pepe")
                .apellidos("Alonso")
                .email("pepe@gmail.com")
                .telefono("934546771")
                .dni("87654321B")
                .asiento("B2")
                .fechaAbono("2021-01-01")
                .build();

        SocioAbonado socioAbonado3 = SocioAbonado.builder()
                .nombre("Gonzalo")
                .apellidos("García")
                .email("gonzalo@gmail.com")
                .telefono("934546771")
                .dni("87654321B")
                .asiento("B2")
                .fechaAbono("2021-01-01")
                .build();

        socioAbonadoRepository.save(socioAbonado1);
        socioAbonadoRepository.save(socioAbonado2);
        socioAbonadoRepository.save(socioAbonado3);


        System.out.println();
        System.out.println("Numero de socios: " + socioRepository.count());

        System.out.println(socioRepository.findAll());
        System.out.println(socioAbonadoRepository.findAll());
        System.out.println();

    }

}
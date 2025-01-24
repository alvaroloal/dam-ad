package com.salesianos.herencia.singleTable;

import com.salesianos.herencia.singleTable.model.Delantero;
import com.salesianos.herencia.singleTable.model.Portero;
import com.salesianos.herencia.singleTable.repos.JugadorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Seed {

    private final JugadorRepository jugadorRepository;

    @PostConstruct
    public void init() {

        Delantero delantero1 = new Delantero(null, "Isaac Romero", 25, 11500.0, 50, 9, 15);
        Delantero delantero2 = new Delantero(null, "Dodi Lukebakio", 28, 11800.0, 60, 11, 20);
        Delantero delantero3 = new Delantero(null, "Lionel Messi", 34, 11800.0, 160, 10, 5520);

        Portero portero1 = new Portero(null, "Ter Stegen", 30, 22000.0, 80, 1, 25);
        Portero portero2 = new Portero(null, "Buffon", 52, 12200.0, 100, 13, 30);
        Portero portero3 = new Portero(null, "Andres Palop", 42, 12200.0, 100, 1, 1);



        jugadorRepository.save(delantero1);
        jugadorRepository.save(delantero2);
        jugadorRepository.save(delantero3);

        jugadorRepository.save(portero1);
        jugadorRepository.save(portero2);
        jugadorRepository.save(portero3);



        System.out.println("Jugadores en la base de datos:");
        System.out.println("Delantero 1: " + delantero1 + "goles:" + delantero1.getGoles());
        System.out.println("Delantero 2: " + delantero2);
        System.out.println("Delantero 3: " + delantero3 + "goles:" + delantero3.getGoles());

        System.out.println("Portero 1: " + portero1);
        System.out.println("Portero 2: " + portero2);
        System.out.println("Portero 3: " + portero3);
        System.out.println();
    }
}

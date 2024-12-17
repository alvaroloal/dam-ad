package com.salesianostriana.dam.resteval;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PlaceRepository {

    private HashMap<Long, Place> places = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        // Añadir aquí datos de ejemplo
        add(Place.builder().id(1L).name("Las Niñas").address("Calle Malvaloca, 17").coords("1.121212121, 4.212312341").desc("Un sitio donde ni Falete se queda con hambre").tags(List.of("Bar", "Restaurante", "Recomendado")).image("Imagen de un bar").build());
        add(Place.builder().id(2L).name("Bar Galindón").address("Calle Cánovas del Castillo, 84").coords("2.121212412415, 6.1241241561").desc("El mejor bar que hay en la Puebla de los Infantes").tags(List.of("Bar", "Restaurante", "Mu weno")).image("Imagen de un bar").build());
    }

    public Place add(Place place) {
        var id = counter.incrementAndGet();
        place.setId(id);
        places.put(id, place);
        return place;
    }

    public Optional<Place> get(Long id) {
        return Optional.ofNullable(places.get(id));
    }

    public List<Place> getAll() {
        return List.copyOf(places.values());
    }

    public Optional<Place> edit(Long id, Place place) {
        return Optional.ofNullable(places.computeIfPresent(id, (k,v) -> {
            v.setName(place.getName());
            v.setDesc(place.getDesc());
            v.setImage(place.getImage());
            v.setCoords(place.getCoords());
            v.setAddress(place.getAddress());
            return v;
        }));
    }

    public void delete(Long id) {
        places.remove(id);
    }


}

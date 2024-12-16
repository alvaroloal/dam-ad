package com.salesianostriana.dam.monumentov2.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Monumento.builder()
                .id(1L)
                .countryCode("US")
                .countryName("United States")
                .cityName("New York")
                .latitude(40.7128)
                .longitude(-74.0060)
                .name("Statue of Liberty")
                .description("The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Statue_of_Liberty_7.jpg/800px-Statue_of_Liberty_7.jpg")
                .build());
        add(Monumento.builder()
                .id(2L)
                .countryCode("JP")
                .countryName("Japan")
                .cityName("Tokyo")
                .latitude(35.6895)
                .longitude(139.6917)
                .name("Tokyo Tower")
                .description("The Tokyo Tower is a communications and observation tower in the Shiba-koen district of Minato, Tokyo, Japan.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Tokyo_Tower_and_Fuji.jpg/800px-Tokyo_Tower_and_Fuji.jpg")
                .build());
        add(Monumento.builder()
                .id(3L)
                .countryCode("EG")
                .countryName("Egypt")
                .cityName("Giza")
                .latitude(29.9773)
                .longitude(31.1325)
                .name("Great Pyramid of Giza")
                .description("The Great Pyramid of Giza is the oldest and largest of the three pyramids in the Giza pyramid complex in Egypt.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/800px-Kheops-Pyramid.jpg")
                .build());
        add(Monumento.builder()
                .id(4L)
                .countryCode("AU")
                .countryName("Australia")
                .cityName("Sydney")
                .latitude(-33.8568)
                .longitude(151.2153)
                .name("Sydney Opera House")
                .description("The Sydney Opera House is a multi-venue performing arts centre in Sydney, Australia.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Sydney_Opera_House_-_Dec_2008.jpg/800px-Sydney_Opera_House_-_Dec_2008.jpg")
                .build());
    }


    public Monumento add(Monumento monumento) {
        long id = counter.incrementAndGet();
        monumento.setId(id);
        monumentos.put(id, monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable((Monumento) monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento newMonument) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCityName(newMonument.getCityName());
            v.setImage(newMonument.getImage());
            v.setDescription(newMonument.getDescription());
            v.setLatitude(newMonument.getLatitude());
            v.setCountryCode(newMonument.getCountryCode());
            v.setLongitude(newMonument.getLongitude());
            v.setCountryName(newMonument.getCountryName());
            v.setName(newMonument.getName());

            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> query(double maxLatitude, String sortDirection) {
        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if (maxLatitude < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getLatitude() <= maxLatitude)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monumento::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monumento::getName).reversed());

        return Collections.unmodifiableList(result);
    }


}



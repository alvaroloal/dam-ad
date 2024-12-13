package com.example.monumentos;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentRepository {

    private HashMap<Long, Monument> monuments = new HashMap<>();

    @PostConstruct
    public void init() {

        add(Monument.builder().id(1L).monumentName("Cibeles").cityName("Madrid").countryIsoCode("ES").countryName("España")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(2L).monumentName("Camp Nou").cityName("Barcelona").countryIsoCode("ES").countryName("España")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(3L).monumentName("Palacio de Vázquez de Molina").cityName("Úbeda").countryIsoCode("ES").countryName("España")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(4L).monumentName("Mercado do Bolhao").cityName("Oporto").countryIsoCode("PT").countryName("Portugal")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(5L).monumentName("Torre de Belém").cityName("Lisboa").countryIsoCode("PT").countryName("Portugal")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(6L).monumentName("Big Ben").cityName("Londres").countryIsoCode("UK").countryName("Reino Unido")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(7L).monumentName("Giralda").cityName("Sevilla").countryIsoCode("ES").countryName("España")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(8L).monumentName("Nuevo Colombino").cityName("Huelva").countryIsoCode("ES").countryName("España")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(9L).monumentName("Coliseo").cityName("Roma").countryIsoCode("IT").countryName("Italia")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());
        add(Monument.builder().id(10L).monumentName("Duomo di Milano").cityName("Milan").countryIsoCode("IT").countryName("Italia")
                .description("Monumento increíble").latitude(40.416775).longitude(-3.703790).image("http://example.com/bernabeu.jpg").build());

    }

    public Monument add(Monument monument) {
        monuments.put(monument.getId(), monument);
        return monument;
    }

    public Optional<Monument> get(Long id) {
        return Optional.ofNullable(monuments.get(id));
    }

    public List<Monument> getAll() {
        return List.copyOf(monuments.values());
    }

    public Optional<Monument> edit(Long id, Monument newMonument) {
        return Optional.ofNullable(monuments.computeIfPresent(id, (k, v) -> {
            v.setCityName(newMonument.getCityName());
            v.setImage(newMonument.getImage());
            v.setDescription(newMonument.getDescription());
            v.setLatitude(newMonument.getLatitude());
            v.setCountryIsoCode(newMonument.getCountryIsoCode());
            v.setLongitude(newMonument.getLongitude());
            v.setCountryName(newMonument.getCountryName());
            v.setMonumentName(newMonument.getMonumentName());


            return v;
        }));
    }

    public void delete(Long id) {
        monuments.remove(id);
    }

    public List<Monument> query(String countryName, String sortDirection) {
        List<Monument> data = new ArrayList<>(monuments.values());
        List<Monument> result = new ArrayList<>();

        if (countryName.equalsIgnoreCase("all")) {
            result = data;
        } else {
            result = data.stream().filter(m -> m.getCountryName()
                    .equalsIgnoreCase(countryName)).collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monument::getMonumentName));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monument::getMonumentName).reversed());

        }

        return Collections.unmodifiableList(result);


    }

}

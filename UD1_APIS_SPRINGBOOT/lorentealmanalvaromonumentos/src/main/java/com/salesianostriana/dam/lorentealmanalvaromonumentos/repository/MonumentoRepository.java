package com.salesianostriana.dam.lorentealmanalvaromonumentos.repository;

import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monumento.builder().id(1L).codPais("1234").nombrePais("España").nombreCiudad("Sevilla").latitud(22.2).longitud(21.1).nombreMonumento("Torre del Oro").descripcion("Monumento situado en la orilla del Guadalquivir").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());
        add(Monumento.builder().id(2L).codPais("6789").nombrePais("España").nombreCiudad("Sevilla").latitud(33.2).longitud(50.1).nombreMonumento("Giralda").descripcion("Situada en la plaza virgen de los reyes").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());
        add(Monumento.builder().id(3L).codPais("1234").nombrePais("España").nombreCiudad("Sevilla").latitud(22.2).longitud(21.1).nombreMonumento("Palacio San Telmo").descripcion("Monumento situado en la orilla del Guadalquivir").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());
        add(Monumento.builder().id(4L).codPais("1234").nombrePais("España").nombreCiudad("Sevilla").latitud(22.2).longitud(21.1).nombreMonumento("Plaza de España").descripcion("Monumento situado en la orilla del Guadalquivir").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());
        add(Monumento.builder().id(5L).codPais("1234").nombrePais("España").nombreCiudad("Sevilla").latitud(22.2).longitud(21.1).nombreMonumento("Plaza de toros").descripcion("Monumento situado en la orilla del Guadalquivir").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());
        add(Monumento.builder().id(6L).codPais("1234").nombrePais("España").nombreCiudad("Sevilla").latitud(22.2).longitud(21.1).nombreMonumento("Catedral").descripcion("Monumento situado en la orilla del Guadalquivir").fotoUrl("https://ca.wikipedia.org/wiki/Torre_del_Oro").build());

    }

    public Monumento add(Monumento monumento) {
        monumentos.put(monumento.getId(), monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento newValue) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCodPais(newValue.getCodPais());
            v.setNombrePais(newValue.getNombrePais());
            v.setNombreMonumento(newValue.getNombreMonumento());
            v.setNombreCiudad(newValue.getNombreCiudad());
            v.setLatitud(newValue.getLatitud());
            v.setLongitud(newValue.getLongitud());
            v.setNombreCiudad(newValue.getNombreCiudad());
            v.setDescripcion(newValue.getDescripcion());
            v.setFotoUrl(newValue.getFotoUrl());
            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> query (double maxLat, String sortDirection) {

        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if(maxLat < 0) {
            result = data;
        }
        else {
            result = data.stream()
                    .filter(monumento -> monumento.getLatitud() <= maxLat)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if(sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monumento::getNombreMonumento));
        else if(sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monumento::getNombreMonumento).reversed());


        return Collections.unmodifiableList(result);
    }



}
package com.salesianostriana.dam.monumentos.AlvaroLorenteAlman_Monumentos;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.monumentos.AlvaroLorenteAlman_Monumentos.model.Monumento;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class InitData {
    @PostConstruct
    public void init(){
        Monumento torreEifel = new Monumento();

        torreEifel.setCodPais("FR");
        torreEifel.setNombrePais("Francia");
        torreEifel.setNombreCiudad("París");
        torreEifel.setLatitud(200000);
        torreEifel.setLongitud(200000);
        torreEifel.setNombreMonumento(null);
        torreEifel.setDescripcion("Torre alta de París");
        torreEifel.setFotoUrl("url");

    }
    
}

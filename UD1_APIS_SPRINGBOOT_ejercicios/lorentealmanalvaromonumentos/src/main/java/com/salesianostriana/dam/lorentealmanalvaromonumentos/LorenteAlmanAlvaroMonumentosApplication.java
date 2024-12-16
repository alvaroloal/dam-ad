package com.salesianostriana.dam.lorentealmanalvaromonumentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info =
@Info(description = "API que gestiona los monumentos más populares de el mundo",
		version = "1.0",
		contact = @Contact(
				email = "lorente.alalv24@triana.salesianos.edu",
				name = "Álvaro Lorente Almán"),
		license = @License(
				name = "Ejercicio de ejemplo"),
		title = "API sobre monumentos")
)
@SpringBootApplication
public class LorenteAlmanAlvaroMonumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LorenteAlmanAlvaroMonumentosApplication.class, args);
	}

}

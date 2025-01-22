package com.salesianos.triana.dam.ejercicio03;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info =
@Info(description = "Una API REST sobre el ejercicio 3 de modelado de datos",
		version = "1.0",
		contact = @Contact(
				email = "lorente.alalv24@triana.salesianos.edu",
				name = "Álvaro Lorente Almán"),
		license = @License(
				name = "2º DAM"),
		title = "API REST Bicicletas - Estaciones")
)
@SpringBootApplication
public class Ejercicio03Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio03Application.class, args);
	}

}

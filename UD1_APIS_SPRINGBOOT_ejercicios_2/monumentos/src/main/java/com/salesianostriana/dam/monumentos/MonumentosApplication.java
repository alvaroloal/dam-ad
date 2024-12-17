package com.salesianostriana.dam.monumentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(description =
		"Una API para mostrar los datos de Monumentos de todo el mundo",
		version = "1.0",
		contact = @Contact(
				email = "gonzalez.coser24@triana.salesianos.edu",
				name = "Sergio"
		),
		license = @License(
				name = "Sergio González Cortés"
		),
		title = "API sobre monumentos")
)
public class MonumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentosApplication.class, args);
	}

}

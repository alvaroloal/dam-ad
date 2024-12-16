package com.salesianostriana.dam.monumentov2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(info =
@Info(description = "Una API de ejemplo para generar documentación con Swagger",
		version = "1.0",
		contact = @Contact(
				email = "lorente.alalv24@triana.salesianos.edu",
				name = "Alvaro Lorente"),
		license = @License(
				name = "Kalise para todos"),
		title = "API sobre monumentos")
)
@SpringBootApplication
public class Monumentov2Application {

	public static void main(String[] args) {
		SpringApplication.run(Monumentov2Application.class, args);
	}

}

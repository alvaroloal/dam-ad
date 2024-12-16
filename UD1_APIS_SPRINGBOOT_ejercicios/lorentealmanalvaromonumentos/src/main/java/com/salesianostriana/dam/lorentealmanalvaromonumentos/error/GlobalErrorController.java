package com.salesianostriana.dam.lorentealmanalvaromonumentos.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;


@RestControllerAdvice
public class GlobalErrorController
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonumentoNotFoundException.class)
    public ProblemDetail handleProductNotFound(MonumentoNotFoundException ex) {
        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        ex.getMessage());
        result.setTitle("Producto no encontrado");
        result.setType(URI.create("https://www.salesianos-triana.edu/errors/product-not-found"));
        result.setProperty("author", "Luismi");

        return result;

    }


}

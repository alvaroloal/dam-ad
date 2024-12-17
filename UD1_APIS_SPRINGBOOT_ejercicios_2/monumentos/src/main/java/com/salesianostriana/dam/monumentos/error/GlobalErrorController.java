package com.salesianostriana.dam.monumentos.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonumentoNoEncontradoException.class)
    public ProblemDetail handleMonumentNotFound(MonumentoNoEncontradoException exception) {

        ProblemDetail result = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        exception.getMessage());
        result.setTitle("Monumento no encontrado");
        result.setType(URI.create("https://readytogosurvival.com/not-found"));

        return result;
    }
}

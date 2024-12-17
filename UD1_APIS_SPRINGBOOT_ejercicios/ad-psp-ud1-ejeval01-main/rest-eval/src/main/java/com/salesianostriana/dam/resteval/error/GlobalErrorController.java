package com.salesianostriana.dam.resteval.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlaceNotFoundException.class)
    public ProblemDetail handlePlaceNotFoundException(PlaceNotFoundException exception) {

        ProblemDetail detail = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND,
                        exception.getMessage());
        detail.setTitle("Lugar no encontrado");

        return detail;
    }
}

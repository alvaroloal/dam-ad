package com.salesianostriana.dam.monumentos.error;

public class MonumentoNoEncontradoException extends RuntimeException {
    public MonumentoNoEncontradoException(String message) {
        super(message);
    }

    public MonumentoNoEncontradoException(Long id) {
        super("No se ha encontrado un monumento con el ID: %d".formatted(id));
    }

    public MonumentoNoEncontradoException() {
        super("No se ha encontrado un monumento con esas características");
    }

}

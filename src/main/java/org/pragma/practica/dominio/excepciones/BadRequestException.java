package org.pragma.practica.dominio.excepciones;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

}
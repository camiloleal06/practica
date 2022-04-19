package org.pragma.practica.dominio.excepciones;

public class NotFoundException extends RuntimeException {
       public NotFoundException(String mensaje) {
            super(mensaje);
        }
    }

